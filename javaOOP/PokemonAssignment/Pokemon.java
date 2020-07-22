public class Pokemon{
    
    // I) Attributes of the Class
    protected String name;
    protected int health;
    protected String type;
    private static int pokemonCount = 0;

    // II) Constructor of the Class
    public Pokemon(String name, int health, String type){
        this.name = name;
        this.health = health;
        this.type = type;
        pokemonCount++;
    }

    // III) Customized Methods
    public void attackPokemon(Pokemon pokemon) {
        pokemon.health -= 10;
    }
    public static int pokemonCount() {
        return pokemonCount;   
    }


    // IV) Getter and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

       
}