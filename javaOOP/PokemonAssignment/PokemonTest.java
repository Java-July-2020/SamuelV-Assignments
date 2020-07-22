public class PokemonTest {
    public static void main(String[] args){

        // 0) Instantiating a Pokedex and adding pokemons to it
        Pokedex pokedex = new Pokedex();
        
        Pokemon pokemon_1 = pokedex.createPokemon("Picachu",100,"Electric");
        Pokemon pokemon_2 = pokedex.createPokemon("Charmander",100,"Fire");
        Pokemon pokemon_3 = pokedex.createPokemon("Squirtle",100,"Water");
        Pokemon pokemon_4 = pokedex.createPokemon("Bulbasaur",100,"Seed");

        pokedex.myPokemons.add(pokemon_1); //adding Pikachu
        pokedex.myPokemons.add(pokemon_2); //adding Charmander
        pokedex.myPokemons.add(pokemon_3); //adding Squirtle
        pokedex.myPokemons.add(pokemon_4); //adding Bulbasaur


        //I) Showing list of Pokemons in Pokedex

        System.out.println("\nI) These are the pokemons I have in my Pokedex:");
        pokedex.listPokemon();
        System.out.println("I have " + Pokemon.pokemonCount() +" in my Pokedex");

        //II) Showing info of each Pokemon in my Pokedex

        System.out.println("\nII) These are the initial status and info of my pokemons:");
        for (Pokemon thisPokemon : pokedex.myPokemons){
            System.out.println(pokedex.pokemonInfo(thisPokemon));
        }

        //III) Pokemons attacking each other:
        
        System.out.println("\nIII) Pokemons attacking each other:");
        System.out.println("Pikachu attacks Charmander!");
        pokemon_1.attackPokemon(pokemon_2); // Pikachu attacks Charmander
        System.out.println("Charmander attacks Squirtle!");
        pokemon_2.attackPokemon(pokemon_3); // Charmander attacks Squirtle
        System.out.println("Bulbasaur attacks Squirtle!");
        pokemon_4.attackPokemon(pokemon_3); // Bulbasaur attacks Squirtle
        
        System.out.println("\nThese are the final status of my pokemons after attacking:");
        for (Pokemon thisPokemon : pokedex.myPokemons){
            System.out.println(pokedex.pokemonInfo(thisPokemon));
        }

        
    }
}