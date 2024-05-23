<script lang="ts">
    import CardPal from "$lib/CardPal.svelte";
    import Header from "$lib/Header.svelte";
	import { onMount } from "svelte";
	import { Card } from "../../models/Card";


    let cardsMount:Card[] = [];
    // function lifecycle => s'execute quand le DOM a chargé.
onMount(async ()=> {
    const res = await fetch("http://localhost:8080/cards-api/v1/cards");
    cardsMount = await res.json();
    })


</script>
<Header/>

<div class="card-wrapper">
    <div class="gallerie">
    {#each cardsMount as item}
        <CardPal card={item}/>    
        {:else}
        <!-- si 0 cartes found -->
        <span class="loading loading-spinner loading-lg"></span>
    {/each}
    </div> 
</div>

<style>
    .card-wrapper {
        display: flex;
        gap: 1em;
        justify-content: center;
        flex-wrap: wrap;
        margin:1em;
        height: 100%;
    }
    .gallerie {
        display: flex;
        height: fit-content;
        gap: 2em;
        flex-wrap: wrap;
        justify-content: center;
    }

</style>