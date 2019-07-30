package database;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.Table;

@Table("goods_attachments")
@BelongsTo(parent = Goods.class, foreignKeyName = "goods_id")
public class GoodsAttachment extends Model {

    public static Model getGoodsAttachment(String goodsId){
        return findBySQL("SELECT * FROM goods_attachments WHERE goods_id = "+ goodsId + " AND \"order\" = 0;").get(0);
    }
}
