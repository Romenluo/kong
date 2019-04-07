package com.li.kong.test;

import com.li.kong.entity.Information;
import com.li.kong.service.InformationService;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class InfoTest {

    public @Test
    void saveInfoTest(){
        InformationService is = new InformationService();
        long dd = new Date().getTime();

        Information info = new Information();
        info.setTitle("资讯一");
        info.setContent("fydnsuiygheujg9ihifhiudshsidhfiisdfhnsdh恢复和反思u后服务UI和gig红酒和官方机构发黑和覅ughi会被放大");
        info.setDownVote(0);
        info.setUpVote(0);
        int count = is.save(info);
        System.out.println(count);

    }

    public @Test
    void findAllTest(){
        InformationService is = new InformationService();
        List<Information> list = is.findAll();
        long dd = new Date().getTime();
        System.out.println(dd);
        /*for(Information info: list){
            System.out.println(info.getInfoDate());
        }*/
    }

    public @Test
    void deleteTest(){
        InformationService is = new InformationService();
        boolean dd = is.deleteInfo(1);
        System.out.println(dd);
    }

    public @Test
    void updateTest(){
        InformationService is = new InformationService();
        Information information = is.find(1);
        information.setTitle("门门");
        information.setUpVote(2);
        boolean dd = is.update(information);
        System.out.println(dd);
    }

}
