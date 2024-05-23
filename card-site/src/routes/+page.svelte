<script>
	import Card from "$lib/Card.svelte";
import Header from "$lib/Header.svelte";

</script>
<Header/>

<div class="card-wrapper">
    <div class="card">
        <Card title="Buy" description = "Buy cards" buttonText = "Buy now!" redirectLink="buy"/>
    </div>
    <div class="card">
        <Card title="Market" description = "Sell cards" buttonText = "Sell now!"/>    
    </div>
    <div class="card">
        <Card title="Play" description = "Play with cards" buttonText = "Play now!"/>    
    </div>
</div>

<style>
    .card-wrapper {
        display: flex;
        flex-wrap: wrap;
        width: 100%;
        justify-content: center;
        gap: 5em;
        margin-top: 5em;

    }
</style>