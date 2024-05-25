import { UserLogin } from '../models/UserLogin';

export function buildPostRequest(object: Object, url: string, jwtoken: string): void {
	const xhr = new XMLHttpRequest();
	xhr.open('POST', url);
	xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
	xhr.setRequestHeader('Authorization', 'Bearer ' + jwtoken);
	const body = JSON.stringify(object);
	xhr.onload = () => {
		if (xhr.readyState == 4 && xhr.status == 201) {
			console.log(JSON.parse(xhr.responseText));
		} else {
			console.log(`Error: ${xhr.status}`);
		}
	};
	xhr.send(body);
}