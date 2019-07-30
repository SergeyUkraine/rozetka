package database;

import org.javalite.activejdbc.LazyList;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

import java.util.List;

@Table("goods")
public class Goods extends Model {

    public static Model getRandomGoodsObject() {
        return findBySQL("SELECT * FROM goods WHERE status = 'active'\n" +
                "                 AND sell_status = 'available' AND status_inherited = 'active' and  id >= random()*\n" +
                "( SELECT MAX (id ) FROM goods ) \n" +
                "ORDER BY id LIMIT 1").get(0);
    }

    public static Model getRandomGoodsObject(String status, String sellStatus, String statusInherited) {
        String q = "SELECT * FROM goods WHERE status = "+"'"+"%s"+"'" +
                "                 AND sell_status = "+"'"+"%s"+"'" + " AND status_inherited = "+"'"+"%s"+"'" + " and  id >= random()*\n" +
                "                ( SELECT MAX (id ) FROM goods )\n" +
                "                ORDER BY id LIMIT 1";
        return findBySQL(String.format(q, status, statusInherited, sellStatus)).get(0);
    }

    public static Model getRandomGoodsObject(String status, String sellStatus, String statusInherited, int categoryId) {
        String q = "SELECT * FROM goods WHERE status =  "+"'"+"%s"+"'"+
                " AND sell_status =  "+"'"+"%s"+"'" + " AND status_inherited =  "+"'"+"%s"+"'"  + " AND category_id = " +
                  categoryId  +  " AND  id >= random()*\n" +
                "( SELECT MAX (id ) FROM goods )\n" +
                " ORDER BY id LIMIT 1";
        LazyList<Model> list = findBySQL(String.format(q, status, statusInherited, sellStatus, categoryId));
        return list.get(0);
    }

    public static List<?> getValueOfId(Object categoryId, String value){
        return findBySQL("SELECT g." + value + " FROM goods as g JOIN dblink('host=10.10.8.123 port=6432 dbname=recommendations user=postgres password=postgres','SELECT product_id , parent_id , category_rank , order_val from most_growing') as r(\n" +
                "               product_id bigint,\n" +
                "               parent_id bigint,\n" +
                "               category_rank bigint,\n" +
                "               order_val bigint\n" +
                "     ) ON  r.product_id = g.id WHERE r.parent_id = " +  categoryId  +" AND  g.sell_status in  ('limited','available') ORDER BY r.order_val ASC LIMIT 24;").collect(value);
    }

    public static List<Double> getPrice(Object categoryId, String value){
        return findBySQL("SELECT g." + value + " FROM goods as g JOIN dblink('host=10.10.8.123 port=6432 dbname=recommendations user=postgres password=postgres','SELECT product_id , parent_id , category_rank , order_val from most_growing') as r(\n" +
                "               product_id bigint,\n" +
                "               parent_id bigint,\n" +
                "               category_rank bigint,\n" +
                "               order_val bigint\n" +
                "     ) ON  r.product_id = g.id WHERE r.parent_id = " +  categoryId  +" AND  g.sell_status in  ('limited','available') ORDER BY r.order_val ASC LIMIT 24;").collect(value);
    }

    public static LazyList<Model> getExlusiveInRozetka(){
        return findBySQL("SELECT \"id\", \"title\",\"price\",\"old_price\",\"href\"\n" +
                "FROM \"goods_tags\" \"gt\"\n" +
                "     LEFT JOIN \"goods\" \"g\" ON gt.goods_id = g.id\n" +
                "WHERE (\"gt\".\"tag_id\" = 1)\n" +
                "  AND (\"g\".\"status\" = 'active')\n" +
                "  AND (\"sell_status\" IN ('available', 'limited'))\n" +
                "ORDER BY \"g\".\"rank\" DESC, \"g\".\"id\" DESC\n" +
                "LIMIT 24");
    }

    public static LazyList<Model> getTopCommented(){
        return findBySQL("Select g.id, g.title, g.price, g.old_price, g.href, tc.order_val from goods as g JOIN\n" +
                "                 dblink('host=10.10.8.123 port=6432 dbname=recommendations user=postgres password=postgres','Select product_id, order_val from top_commented') as tc(\n" +
                "                 product_id bigint,\n" +
                "                 order_val bigint\n" +
                "                 ) ON  tc.product_id = g.id where g.sell_status = 'available' or g.sell_status = 'limited' order by tc.order_val LIMIT 24;");
    }

    public static LazyList<Model> getHotNewProducts(){
        return findBySQL("Select g.id, g.title, g.price, g.old_price, g.href, tc.order_val from goods as g JOIN\n" +
                "                 dblink('host=10.10.8.123 port=6432 dbname=recommendations user=postgres password=postgres','Select product_id, order_val from hot_new_products') as tc(\n" +
                "                 product_id bigint,\n" +
                "                 order_val bigint\n" +
                "                 ) ON  tc.product_id = g.id where g.sell_status = 'available' or g.sell_status = 'limited' order by tc.order_val LIMIT 24;");
    }

    public static LazyList<Model> getSectionWished(){
        return findBySQL("Select g.id, g.title, g.price, g.old_price, g.href, mwished.wished from goods as g JOIN\n" +
                "                 dblink('host=10.10.8.123 port=6432 dbname=recommendations user=postgres password=postgres','Select product_id, wished from most_wished') as mwished(\n" +
                "                 product_id bigint,\n" +
                "                 wished bigint\n" +
                "                 ) ON  mwished.product_id = g.id  where g.sell_status = 'available' or g.sell_status = 'limited' order by mwished.wished DESC , g.id DESC LIMIT 24;");
    }

    public static LazyList<Model> getSectionWaited(){
        return findBySQL("Select g.id, g.title, g.price, g.old_price, g.href, mtw.waited from goods as g JOIN\n" +
                "                 dblink('host=10.10.8.123 port=6432 dbname=recommendations user=postgres password=postgres','Select product_id, waited from most_waited') as mtw(\n" +
                "                 product_id bigint,\n" +
                "                 waited bigint\n" +
                "                 ) ON  mtw.product_id = g.id where g.sell_status = 'waiting_for_supply' order by mtw.waited DESC, g.id ASC LIMIT 24;");
    }

    //*  Товар по ИД */
    public static LazyList<Model> getGoodById(Long id_good){
        return findBySQL("Select g.* from goods g where g.id=? ;", id_good);
    }

}
