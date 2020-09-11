package persistance.model;

import javax.persistence.*;
//TODO Add DB relationships, primary and foreign keys to MenuTypeModel
@Entity
@Table (name = "meniu_tip")
public class MenuTypeModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meniu_tip_id")
    private Integer menuTypeId;

    @Column(name = "descriere")
    private String menuType;

    public Integer getMenuTypeId()
    {
        return menuTypeId;
    }

    public void setMenuTypeId(Integer menuTypeId)
    {
        this.menuTypeId = menuTypeId;
    }

    public String getMenuType()
    {
        return menuType;
    }

    public void setMenuType(String menuType)
    {
        this.menuType = menuType;
    }
}
