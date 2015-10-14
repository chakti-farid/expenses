package importDb;

import importDb.Categories;
import importDb.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-04T20:22:06")
@StaticMetamodel(Operations.class)
public class Operations_ { 

    public static volatile SingularAttribute<Operations, Date> date;
    public static volatile SingularAttribute<Operations, Integer> amount;
    public static volatile SingularAttribute<Operations, Integer> id;
    public static volatile SingularAttribute<Operations, Users> userId;
    public static volatile SingularAttribute<Operations, Categories> categoryId;

}