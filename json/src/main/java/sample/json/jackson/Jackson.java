package sample.json.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import sample.json.bean.Bean;
import sample.json.bean.OutterBean;

public class Jackson {
    private ObjectMapper mapper = new ObjectMapper();

    public void str2bean() throws JsonParseException, JsonMappingException, IOException {
        String str = "{\"address\":[\"china\",\"shanxi\"],\"id\":1,\"name\":\"test\"}";
        Bean bean = mapper.readValue(str, Bean.class);

        System.out.println(bean.getId());
        System.out.println(bean.getName());
        System.out.println(bean.getAddress());
    }

    public void bean2str() throws JsonProcessingException {
        Bean bean = new Bean();
        bean.setId(1);
        bean.setName("test");
        bean.setAddress(new String[] { "china", "shanxi" });

        System.out.println(mapper.writeValueAsString(bean));
    }

    public void outter2str() throws JsonProcessingException {
        Bean bean = new Bean();
        bean.setId(1);
        bean.setName("test");
        bean.setAddress(new String[] { "china", "shanxi" });
        OutterBean outter = new OutterBean();
        outter.setId(2);
        outter.setName("outer");
        outter.setBean(bean);

        System.out.println(mapper.writeValueAsString(outter));
    }

    public void str2Outter() throws JsonParseException, JsonMappingException, IOException {
        String str = "{\"bean\":{\"address\":[\"china\",\"shanxi\"],\"id\":1,\"name\":\"test\"},\"id\":2,\"name\":\"outer\"}";
        OutterBean outter = mapper.readValue(str, OutterBean.class);

        System.out.println(outter.getBean().getName());
        System.out.println(outter.getBean().getId());
        System.out.println(outter.getName());
    }

    public void array2str() throws JsonParseException, JsonMappingException, IOException {
        int[] arr = { 1, 2, 3 };
        System.out.println(mapper.writeValueAsString(arr));
    }

    public void str2array() throws JsonParseException, JsonMappingException, IOException {
        String str = "[1,2,3]";
        int[] arr = mapper.readValue(str, int[].class);

        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
    }

    public static void main(String[] args) {
        try {
            Jackson test = new Jackson();
            test.bean2str();
            test.str2bean();
            test.outter2str();
            test.str2Outter();
            test.array2str();
            test.str2array();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
