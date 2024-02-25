package com.my.MyPageEventListener.util;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class StringToListWrapper {

    public List<String> stringToList(String str) {
        return convertStringToList(str);
    }
    private List<String> convertStringToList(String str){
        if (str == null) {
            return null;
        }else {
            String[] splitedStr = str.split(", ");
            return Arrays.stream(splitedStr).toList();
        }
    }

}
