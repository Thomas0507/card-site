<script lang="ts">
    export let title: String = "Card title";
    export let description: String = "Card description";
    export let buttonText: String = "Button Text"
</script>


<div class="card w-96 bg-primary text-primary-content card-custom" >
    <div class="card-body">
      <h2 class="card-title">{title}</h2>
      <p>{description}</p>
      <div class="card-actions justify-end">
        <button class="btn">{buttonText}</button>
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