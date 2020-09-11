package persistance.model;

import javax.persistence.*;

//TODO Add DB relationships, primary and foreign keys to MenuModel
@Entity
@Table(name = "meniu")
public class MenuModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descriere")
    private String description;

    @Column(name = "fk_meniu_tip_id")
    private Integer menuTypeId;

    @Column(name = "pret")
    private Integer price;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Integer getMenuTypeId()
    {
        return menuTypeId;
    }

    public void setMenuTypeId(Integer menuTypeId)
    {
        this.menuTypeId = menuTypeId;
    }

    public Integer getPrice()
    {
        return price;
    }

    public void setPrice(Integer price)
    {
        this.price = price;
    }
}