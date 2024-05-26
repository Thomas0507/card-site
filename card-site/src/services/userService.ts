/**
 * @param: none
 * @returns: true if user is connected, false otherwise
 */
export function isUserConnected(): boolean {
	const token = sessionStorage.getItem('token');
	return token !== null && token !== undefined;
}
