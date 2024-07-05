import {environment} from "../../environments/environment";

export const KeyCloakConfig = {
  url: environment.keycloak.issuer,
  realm: environment.keycloak.realm,
  clientId: environment.keycloak.clientId
};
