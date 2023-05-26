package com.bilgeadam.utility;

import com.bilgeadam.controller.FutbolcuController;
import com.bilgeadam.repository.FutbolcuRepository;
import com.bilgeadam.repository.TakimRepository;
import com.bilgeadam.repository.entity.Futbolcu;
import com.bilgeadam.repository.entity.Takim;
import com.bilgeadam.service.FutbolcuService;


/*
1-entity olusturulacak
2-repository
3-service
4-controller
5-utility paketi isteğe ve yapıya bağlı olarak her katmanda olusturulabilir



 */


public class Test {


    public static void main(String[] args) {
        ConnectionProvider connectionProvider=new ConnectionProvider();
//
//        Takim takim=new Takim(2L,"Java9");
//        TakimRepository takimRepository=new TakimRepository(connectionProvider);
//        takimRepository.save(takim);
//        Futbolcu futbolcu1=Futbolcu.builder()
//                .isim("Emre Sefa Özcan")
//                .formaNo(14)
//                .mevki("Sağ Kanat")
//                .deger(3000000L)
//                .takimId(4L)
//                .build();
        Futbolcu futbolcu2=Futbolcu.builder()
                .isim("Berk Aktaş Antalya")
                .formaNo(1)
                .mevki("Defans")
                .deger(3000000L)
                .takimId(4L)
                .id(2L)
                .build();
        FutbolcuController futbolcuController=new FutbolcuController(connectionProvider);
     //   futbolcuController.update(futbolcu2);


//        futbolcuController.save(futbolcu1);
//        futbolcuController.save(futbolcu2);

        futbolcuController.findAll().forEach(System.out::println);

    }
}
