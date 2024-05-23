<script lang="ts">
	import { goto } from "$app/navigation";

    export let title: string = "Card title";
    export let description: string = "Card description";
    export let buttonText: string = "Button Text"
    export let redirectLink: string = "";

    function redirectTo(url: string) {
      goto("/"+url);
    }
</script>


<div class="card w-96 bg-primary text-primary-content card-custom" >
    <div class="card-body">
      <h2 class="card-title">{title}</h2>
      <p>{description}</p>
      <div class="card-actions justify-end">
        <button class="btn" on:click={() =>redirectTo(redirectLink)}>{buttonText}</button>
      </div>
    </div>
  </div>

  <style>
    .card-custom {
        background-color: #D3D3D3;
        color:black;
        border: solid;
    }
    .btn {
        border: solid;
    }
  </style>