package database;


import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.Table;

@Table("goods_attachments_variants")
@BelongsTo(parent = GoodsAttachment.class, foreignKeyName = "parent_id")
public class GoodsAttachmentVariant extends Model {


    public static Object getUrlOfHref(long goodsid){
        return findBySQL("SELECT distinct on(ga.goods_id) v.url FROM goods_attachments ga LEFT JOIN goods_attachments_variants v ON v.parent_id=ga.id WHERE (\"ga\".\"goods_id\" = " + goodsid + " AND (\"ga\".\"group_name\"='images') AND (\"v\".\"variant\"='base_action')) ORDER BY ga.goods_id, ga.order").collect("url").get(0);
    }

    public static Model getFirstBig(String imageId ){
        return findBySQL("SELECT * FROM goods_attachments_variants WHERE parent_id = " +  imageId + " AND variant = 'big'").get(0);
    }



}
