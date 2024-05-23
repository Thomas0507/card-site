import { goto } from "$app/navigation";

// fonction redirection classique
export function redirectToUrl(url: string) {
    return goto(url);
}