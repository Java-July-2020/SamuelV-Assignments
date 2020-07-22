import java.util.ArrayList;

public class Pokedex extends AbstractPokemon {
    
    // I) Attributes of the Class
    protected ArrayList<Pokemon> myPokemons;

    // II) Constructor of the Class
    public Pokedex(){
        this.myPokemons = new ArrayList<Pokemon>();
    }

    /// III) Implementing Interface Methods ("listPokemon" method)
    public void listPokemon(){
        for(Pokemon aPokemon : myPokemons){
            System.out.println("- " + aPokemon.name);
        }
    }

}