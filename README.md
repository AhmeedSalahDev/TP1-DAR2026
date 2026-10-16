# TP1-DAR2026 — Les sockets en mode connecté TCP

**Matière :** Développement d'applications réparties — LSI 3
**Faculté des Sciences de Sfax** — Année universitaire 2026–2027

> **Note :** sous chaque capture, le bloc « Contenu de la capture » décrit exactement ce qui doit apparaître à l'écran. Supprimez ces blocs une fois vos captures insérées.

---

## Activité 1-1 : Première connexion Client/Serveur

### Capture 1 — Serveur en attente
![Capture d'écran 2026-10-16 220749.png](captures/Capture%20d%27%C3%A9cran%202026-10-16%20220749.png)
Le serveur crée un `ServerSocket` sur le port 1234 et reste bloqué sur `accept()` en attendant la connexion d'un client.

> **Contenu de la capture :**
> - Lancez **seulement** la classe `server` (pas le client).
> - Capturez la console d'IntelliJ qui affiche une seule ligne :
    >   `Je suis un serveur en attente la connexion d'un client`
> - Le bouton rouge « Stop » doit être visible (le programme tourne encore, il attend).

### Capture 2 — Client connecté

![Capture d'écran 2026-10-16 220902.png](captures/Capture%20d%27%C3%A9cran%202026-10-16%20220902.png)

Le client se connecte au serveur via `localhost:1234` ; le serveur affiche alors « un client est connecté », puis les deux sockets sont fermés.

> **Contenu de la capture :**
> - Le serveur tourne déjà, puis lancez la classe `client`.
> - Capturez **les deux onglets de console** (server et client), côte à côte ou en deux images :
>   - Console **client** :
      >     `Je suis un client pas encore connecté…`
      >     `je suis un client connecté`
      >     `Process finished with exit code 0`
>   - Console **serveur** :
      >     `Je suis un serveur en attente la connexion d'un client`
      >     `un client est connecté`
      >     `Process finished with exit code 0`

---

## Activité 1-2 : Service de calculatrice (x * 5)

### Capture 3 — Envoi d'un entier et réception du résultat

![Capture d'écran 2026-10-16 221633.png](captures/Capture%20d%27%C3%A9cran%202026-10-16%20221633.png)
![Capture d'écran 2026-10-16 221949.png](captures/Capture%20d%27%C3%A9cran%202026-10-16%20221949.png)
![Capture d'écran 2026-10-16 222007.png](captures/Capture%20d%27%C3%A9cran%202026-10-16%20222007.png)
![Capture d'écran 2026-10-16 222147.png](captures/Capture%20d%27%C3%A9cran%202026-10-16%20222147.png)
![Capture d'écran 2026-10-16 222200.png](captures/Capture%20d%27%C3%A9cran%202026-10-16%20222200.png)
![Capture d'écran 2026-10-16 222233.png](captures/Capture%20d%27%C3%A9cran%202026-10-16%20222233.png)
![Capture d'écran 2026-10-16 222244.png](captures/Capture%20d%27%C3%A9cran%202026-10-16%20222244.png)
Le client saisit un entier x et l'envoie avec `DataOutputStream` ; le serveur le reçoit avec `DataInputStream`, calcule x * 5 et renvoie le résultat (les valeurs positives, négatives et zéro sont correctement transmises).

---

## Activité 1-3 : Amélioration du service de calculatrice

### Capture 4 — Connexion entre deux machines distinctes


Le serveur écoute sur l'adresse IP réelle de sa machine grâce à `InetAddress` et `InetSocketAddress`, et le client se connecte à cette adresse IP au lieu de `localhost`.


### Capture 5 — Calculatrice avec les 4 opérations


Le client choisit une opération dans un menu (addition, soustraction, multiplication, division), envoie le choix et deux entiers au serveur, qui effectue le calcul et renvoie le résultat ; le choix 0 ferme proprement la connexion des deux côtés.
