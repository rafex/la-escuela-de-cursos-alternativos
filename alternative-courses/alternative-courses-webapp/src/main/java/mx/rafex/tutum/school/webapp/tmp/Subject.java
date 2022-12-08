package mx.rafex.tutum.school.webapp.tmp;

public class Subject {

    private Integer id;
    private String name;
    private Integer score;

    public Subject() {
        super();
    }

    public Subject(Integer id, String name, Integer score) {
        super();
        this.id = id;
        this.name = name;
        this.score = score;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Subject [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", score=");
        builder.append(score);
        builder.append("]");
        return builder.toString();
    }

}
