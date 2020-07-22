public interface PokemonInterface {

    abstract Pokemon createPokemon(String name, int health, String type);
    abstract String pokemonInfo(Pokemon pokemon);
    abstract void listPokemon();


}