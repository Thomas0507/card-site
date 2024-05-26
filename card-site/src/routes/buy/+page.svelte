<script lang="ts">
	import CardPal from '$lib/CardPal.svelte';
	import Header from '$lib/Header.svelte';
	import { onMount, setContext } from 'svelte';
	import { Card } from '../../models/Card';

	setContext('buy', { buyCard });

	async function buyCard(card: Card) {
		const token = sessionStorage.getItem('token');
		const result = await fetch('http://localhost:8080/transaction/buy', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
				authorization: `Bearer ${token}`
			},
			body: JSON.stringify(card)
		});
	}

	let cardsMount: Card[] = [];

	onMount(async () => {
		const token = sessionStorage.getItem('token');
		const result = await fetch('http://localhost:8080/cards-api/v1/cards', {
			method: 'GET',
			headers: {
				'Content-Type': 'application/json',
				authorization: `Bearer ${token}`
			}
		});
		const data = await result.json();
		cardsMount = data;
	});
</script>

<Header />

<div class="card-wrapper">
	<div class="gallerie">
		{#each cardsMount as item}
			<CardPal card={item} />
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
		margin: 1em;
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
