<script lang="ts">
    import Header from "$lib/Header.svelte";
	import type { Card } from "../../models/Card";
    let cards: Card[] = [];
</script>
<Header/>

<div class="card-wrapper">
    {#each cards as card }
        <p>card</p>
    {/each}
</div>

<style>
    .card-wrapper {
    }
</style>