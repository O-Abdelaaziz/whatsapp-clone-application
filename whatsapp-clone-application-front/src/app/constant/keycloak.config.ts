import {environment} from "../../environments/environment";

export const KeyCloakConfig = {
  url: environment.keycloak.url,
  realm: environment.keycloak.realm,
  clientId: environment.keycloak.clientId
};
