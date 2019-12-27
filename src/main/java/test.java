import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: Lim
 * @date: 2019/8/21
 */
public class test {
    public static void main(String[] args) {
        String s ="广东省工业和信息化厅,广东省卫生健康委员会,国家税务总局广东省税务局,广东省市场监督管理局,中华人民共和国最高人民法院,中华人民共和国应急管理部,中华人民共和国海关总署,中华人民共和国交通运输部,中华人民共和国国家统计局,中华人民共和国国家市场监督管理总局,中华人民共和国税务总局,中华人民共和国国家发展和改革委员会,广东省市场监督管理局,广东省民政厅,中共广东省委机构编制委员会办公室,广东省司法厅,中华人民共和国税务总局,中华人民共和国交通运输部,中华人民共和国海关总署,中华人民共和国最高人民法院,中华人民共和国海关总署,中华人民共和国交通运输部,中华人民共和国国家统计局,中华人民共和国国家市场监督管理总局,中华人民共和国税务总局,中华人民共和国国家发展和改革委员会,中华人民共和国人力资源和社会保障部,中华人民共和国最高人民法院,中华人民共和国税务总局,中华人民共和国国家市场监督管理总局,中国证券监督管理委员会,中华人民共和国人力资源和社会保障部,中华人民共和国交通运输部,中华人民共和国国家发展和改革委员会,中华人民共和国最高人民法院,广东省高级人民法院";

        String s2 = "广东省市场监督管理局,中共广东省委机构编制委员会办公室,中华人民共和国人力资源和社会保障部,广东省卫生健康委员会,国家税务总局广东省税务局,广东省工业和信息化厅,广东省民政厅,广东省司法厅,中华人民共和国国家发展和改革委员会,广东省高级人民法院,中华人民共和国国家市场监督管理总局,中华人民共和国交通运输部";
        Set<String> set = Arrays.stream(s.split(",")).collect(Collectors.toSet());
        Set<String> set2 = Arrays.stream(s2.split(",")).collect(Collectors.toSet());

        set.removeAll(set2);

        String insert = "insert into api_org_map (api_org) values ('%s');";

        for (String s1 : set) {
            System.out.println(String.format(insert, s1));
        }

        System.out.println(set);


    }
}
