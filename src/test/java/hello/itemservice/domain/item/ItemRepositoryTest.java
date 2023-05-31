package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    @DisplayName("상품 저장")
    void save() {
        // given
        Item item = new Item("itemA", 10000, 10);

        // when
        Item saved = itemRepository.save(item);

        // then
        Item findItem = itemRepository.findById(saved.getId());
        assertThat(findItem).isEqualTo(saved);
    }

    @Test
    @DisplayName("전체 상품 조회")
    void findAll() {
        // given
        Item itemA = new Item("itemA", 10000, 10);
        Item itemB = new Item("itemB", 20000, 20);

        // when
        itemRepository.save(itemA);
        itemRepository.save(itemB);

        List<Item> all = itemRepository.findAll();
        // then
        assertThat(all.size()).isEqualTo(2);
        assertThat(all).contains(itemA, itemB);
    }

    @Test
    @DisplayName("업데이트")
    void updateItem() {
        // given
        Item item = new Item("itemA", 10000, 10);

        Item saved = itemRepository.save(item);
        Long itemId = saved.getId();

        // when
        Item updateParam = new Item("itemB", 20000, 20);
        itemRepository.update(itemId, updateParam);

        // then
        Item findItem = itemRepository.findById(itemId);
        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());
    }

}