<script lang="ts">
    import CardPal from "$lib/CardPal.svelte";
    import Header from "$lib/Header.svelte";
	import { onMount } from "svelte";
	import { Card } from "../../models/Card";


async function getCards() {
    const res = await fetch("http://localhost:8080/cards-api/v1/cards");
    const data = await res.json();
    if (res.ok) {
        return data;
    }
    else
        throw new Error(data);
}

</script>
<Header/>


    {#await getCards()}
        <p>loading...</p>
    {:then items}
    <div class="card-wrapper">
        {#each items as item}
            <CardPal card={item}/>    
         {/each} 
    </div>
        
        {:catch error}
        <p>{error.message}</p>
    {/await}

<style>
    .card-wrapper {
        display: flex;
        gap: 1em;
        justify-content: center;
        flex-wrap: wrap;
        margin:1em;
    }
</style>