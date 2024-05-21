<script lang="ts">
    import CardPal from "$lib/CardPal.svelte";
import Header from "$lib/Header.svelte";
	import { Card } from "../../models/Card";
    let cards: Card[] = [];
    cards.push(new Card( 1, "Lamball", "Just a sheep", 1, "Neutral", 50, 25, 
    "http://localhost:8080/lamball.jpg" ));
</script>
<Header/>

<div class="card-wrapper">
    {#each cards as card }
        <CardPal card = {card}/>
    {/each}
</div>

<style>
    .card-wrapper {
    }
</style>