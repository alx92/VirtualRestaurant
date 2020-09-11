package persistance.model;

import javax.persistence.*;

//TODO Add DB relationships, primary and foreign keys to TableTypeModel
@Entity
@Table(name = "tip_masa")
public class TableTypeModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numar_locuri")
    private Integer nrOfSeats;

    @Column(name = "descriere")
    private String tableType;

    @Column(name = "total_tip_mese")
    private Integer tableTotalByType;

    @Column(name = "total_mese")
    private Integer totalTables;

    public Integer getNrOfSeats()
    {
        return nrOfSeats;
    }

    public void setNrOfSeats(Integer nrOfSeats)
    {
        this.nrOfSeats = nrOfSeats;
    }

    public String getTableType()
    {
        return tableType;
    }

    public void setTableType(String tableType)
    {
        this.tableType = tableType;
    }

    public Integer getTableTotalByType()
    {
        return tableTotalByType;
    }

    public void setTableTotalByType(Integer tableTotalByType)
    {
        this.tableTotalByType = tableTotalByType;
    }

    public Integer getTotalTables()
    {
        return totalTables;
    }

    public void setTotalTables(Integer totalTables)
    {
        this.totalTables = totalTables;
    }
}
