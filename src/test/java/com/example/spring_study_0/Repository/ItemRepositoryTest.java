package com.example.spring_study_0.Repository;

import com.example.spring_study_0.constant.ItemSellStatus;
import com.example.spring_study_0.entity.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
@TestPropertySource(locations="classpath:application.properties")
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @PersistenceContext
    EntityManager em;

//    @Test
//    @DisplayName("상품 저장 테스트")
//    public void createItemTest() {
//        Item item = new Item();
//        item.setItemNm("테스트 상품33333");
//        item.setPrice(10000);
//        item.setItemDetail("테스트 상품 상세 설명3333");
//        item.setItemSellStatus(ItemSellStatus.SELL);
//        item.setStockNumber(100);
////        item.setRegTime(LocalDateTime.now());
////        item.setUpdateTime(LocalDateTime.now());
//        Item savedItem = itemRepository.save(item);
//        System.out.println(savedItem.toString());
//    }

    public void createItemList(){
        for(int i=1;i<=10;i++){
            Item item = new Item();
            item.setItemNm("테스트 상품" + i);
            item.setPrice(10000 + i);
            item.setItemDetail("테스트 상품 상세 설명" + i);
            item.setItemSellStatus(ItemSellStatus.SELL);
            item.setStockNumber(100); item.setRegTime(LocalDateTime.now());
            item.setUpdateTime(LocalDateTime.now());
            Item savedItem = itemRepository.save(item);
        }
    }


    @Test
    @DisplayName("상품명 조회 테스트")
    public void findByItemNmTest(){
        this.createItemList();
        List<Item> itemList = itemRepository.findByItemNm("테스트 상품4");
        for(Item item : itemList){
            System.out.println(item.toString());
            System.out.println("요요");
        }
    }

    @Test
    @DisplayName("@Query를 이용한 상품 조회 테스트")
    public void findByItemDetailTest(){
        this.createItemList();
        List<Item> itemList = itemRepository.findByItemDetail("테스트 상품 상세 설명");
        for(Item item : itemList){
            System.out.println(item.toString());
        }
    }






}