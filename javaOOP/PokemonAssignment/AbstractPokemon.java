public abstract class AbstractPokemon implements PokemonInterface{
   
    // I) Implementing Interface Methods ("createPokemon" and "pokemonInfo" methods). 
    // Obs: "listPokemon" method will be implemented on Pokedex class, which would be a child of this class

    public Pokemon createPokemon(String name, int health, String type){
        Pokemon aPokemon = new Pokemon(name, health, type);
        return aPokemon;
    }

    public String pokemonInfo(Pokemon pokemon){
        String pokemonInfo = "name: " + pokemon.name + " | health: " + pokemon.health + " | type: " + pokemon.type; 
        return pokemonInfo;
    }
}