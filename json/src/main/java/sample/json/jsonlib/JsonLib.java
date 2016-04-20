package jsonlib;

import bean.Bean;
import bean.OutterBean;
import net.sf.json.JSONObject;

public class JsonLib {
    public void str2bean() {
        String str = "{\"address\":[\"china\",\"shanxi\"],\"id\":1,\"name\":\"test\"}";
        JSONObject json = JSONObject.fromObject(str);
        Bean bean = (Bean) JSONObject.toBean(json, Bean.class);

        System.out.println(bean.getId());
        System.out.println(bean.getName());
        System.out.println(bean.getAddress());
    }

    public void bean2str() {
        Bean bean = new Bean();
        bean.setId(1);
        bean.setName("test");
        bean.setAddress(new String[] { "china", "shanxi" });

        JSONObject json = JSONObject.fromObject(bean);
        System.out.println(json.toString());
    }

    public void outter2str() {
        Bean bean = new Bean();
        bean.setId(1);
        bean.setName("test");
        bean.setAddress(new String[] { "china", "shanxi" });
        OutterBean outer = new OutterBean();
        outer.setId(2);
        outer.setName("outer");
        outer.setBean(bean);

        JSONObject json = JSONObject.fromObject(outer);
        System.out.println(json.toString());
    }

    public void str2Outter() {
        String str = "{\"bean\":{\"address\":[\"china\",\"shanxi\"],\"id\":1,\"name\":\"test\"},\"id\":2,\"name\":\"outer\"}";
        JSONObject json = JSONObject.fromObject(str);
        OutterBean outter = (OutterBean) JSONObject.toBean(json, OutterBean.class);

        System.out.println(outter.getBean().getName());
        System.out.println(outter.getBean().getId());
        System.out.println(outter.getName());
    }

    public static void main(String[] args) {
        JsonLib test = new JsonLib();
        test.bean2str();
        test.str2bean();
        test.outter2str();
        test.str2Outter();
    }

}
