<script lang="ts">
	import type { Card } from "../models/Card";

    export let card:Card
</script>

<div class="card w-96 bg-base-100 shadow-xl">
    <figure><img src={card.img} alt="Shoes" /></figure>
    <div class="card-body">
      <h2 class="card-title">{card.name}</h2>
      <p>{card.description}</p>
      <div class="card-actions justify-end">
        <button class="btn btn-primary">Buy Now</button>
      </div>
    </div>
  </div>