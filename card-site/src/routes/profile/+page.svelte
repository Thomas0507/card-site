<!-- display user Info -->

<script lang="ts">
	import CardPal from './../../lib/CardPal.svelte';
	import Header from './../../lib/Header.svelte';
	import { onMount } from 'svelte';

	let userCards: any[] = [];

	onMount(async () => {
		const token = sessionStorage.getItem('token');
		console.log(token);
		const result = await fetch('http://localhost:8080/user/infos', {
			method: 'GET',
			headers: {
				'Content-Type': 'application/json',
				authorization: `Bearer ${token}`
			}
		});
		const data = await result.json();
		// console.log(data);
		userCards = data.cards;

		userCards.forEach((card) => {
			console.log(card);
		});
	});
</script>

<Header />
<h1>My cards</h1>

{#each userCards as card}
	<CardPal card = {card.card}/>
{:else}
	<!-- si 0 cartes found -->
	<span class="loading loading-spinner loading-lg"></span>
{/each}

<div class="card-wrapper">
	<div class="gallerie"></div>
</div>
