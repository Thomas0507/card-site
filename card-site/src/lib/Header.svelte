<script lang="ts">
    import { redirectToUrl } from "../services/redirectService"


</script>

<div class="navbar bg-base-100 header-wrapper">
    <div class="flex-1">
      <p class="btn btn-ghost text-xl" on:click={() => redirectToUrl("/")}>daisyUI</p>
    </div>
    <div class="flex-none user-button-wrapper">
      <ul class="menu menu-horizontal px-1">
        <li>
          <details>
            <summary>
                <i data-feather="circle"></i> User
            </summary>
            <ul class="p-2 bg-base-100 rounded-t-none">
              <li><p on:click={() => redirectToUrl("login")}>Sign in</p></li>
              <li><p on:click={() => redirectToUrl("register")}>Register</p></li>
            </ul>
          </details>
        </li>
        </ul>
    </div>
</div>

<style>
    .header-wrapper {
        background-color:#D3D3D3;
        border-top: solid;
        border-bottom: solid;
    }

    .user-button-wrapper {
        margin-right: 1em;
    }
</style>