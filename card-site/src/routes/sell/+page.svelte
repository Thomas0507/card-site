<!-- display user Info -->

<script lang="ts">
	import CardPalSell from './../../lib/CardPalSell.svelte';
	import CardPalInfo from './../../lib/CardPalInfo.svelte';
	import Header from './../../lib/Header.svelte';
	import { onMount } from 'svelte';
	import { redirectToUrl } from '../../services/redirectService';
	let username: string = '';
	let userCards: any[] = [];

	onMount(async () => {
		const token = sessionStorage.getItem('token');
		const result = await fetch('http://localhost:8080/user/infos', {
			method: 'GET',
			headers: {
				'Content-Type': 'application/json',
				authorization: `Bearer ${token}`
			}
		});
		if (result.status === 401) {
			sessionStorage.clear();
			redirectToUrl('/');
			return;
		}

		const data = await result.json();

		userCards = data.cards;
		username = data.username;
		userCards.forEach((card) => {
			console.log(card);
		});
	});
</script>

<Header />
<div class="flex flex-col w-full border-opacity-50">
	<div class="divider">{username}'s cards</div>
</div>
<div class="card-wrapper">
	<div class="gallerie">
		{#each userCards as card}
			<CardPalSell card={card.card} quantity={card.quantity} />
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
