package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * 
 * @author Johann Wong
 * Adding or deleting of a tag for a person
 */
public class Tagging {
    
    private static final String ADD_SYMBOL = "+";
    private static final String DELETE_SYMBOL = "-";
    private static final String FORMAT_TAG_PREFIX = "[";
    private static final String FORMAT_TAG_SUFFIX = "]";
    private static final String SPACE = " ";
    
    private Person person;
    private Tag tag;
    private Action action;
    
    public static enum Action {
        ADD, DELETE
    }
    
    public Tagging(Person person, Tag tag, Action action){
        this.person = person;
        this.tag = tag;
        this.action = action;
    }
    
    public Person getPerson(){
        return this.person;
    }
    
    public Tag getTag(){
        return this.tag;
    }
    
    public String getFormattedTag(){
        return FORMAT_TAG_PREFIX + this.tag + FORMAT_TAG_SUFFIX;
    }
    
    /**
     * Returns the tag symbol for a person
     */
    public String getTagSymbol(){
        if (this.action == Action.ADD){
            return ADD_SYMBOL;
        } else {
            return DELETE_SYMBOL;
        }
    }
    
    /**
     * Sets the tag symbol for a person
     */
    public void setTagSymbol(){
        if (this.action == Action.ADD) {
            this.action = Action.DELETE;
        }else {
            this.action = Action.ADD;
        }
    }
    
    @Override
    public String toString(){
        StringBuilder build = new StringBuilder();
        build.append(this.getTagSymbol()).append(SPACE);
        build.append(this.person.getName()).append(SPACE);
        build.append(this.getFormattedTag());
        return build.toString();
    }
}
