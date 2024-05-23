import { goto } from "$app/navigation";

export function redirectToUrl(url: string) {
    return goto(url);
}