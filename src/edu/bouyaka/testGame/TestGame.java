package edu.bouyaka.testGame;

import edu.bouyaka.engine.*;
import edu.bouyaka.engine.concreted.*;
import edu.bouyaka.engine.abstracted.*;

public class TestGame {

	public static Gengine engine;

	public static void main(String[] args) {
		// Initialisation du moteur
		engine = new Gengine();

		/*
		 * Initialisation et configuration des différents objets de base
		 */

		// Chargement des fichiers de configuration
		SysConfig basic = new SysConfig("base.cfg", engine);
		SpritesConfig spritesId = new SpritesConfig("spritesId.cfg", engine);

		// Lecture de la configuration
		basic.load();
		spritesId.load();

		// Création d'une interface affichant les informations importantes pour
		// le développement
		engine.addInterface(0);
		Interface devInterface = new Interface();
		engine.replaceInterface(0, devInterface);
		devInterface.enable(true);
		devInterface.setVisible(true);

		// Création d'un bouton affichant la console
		engine.addButton(0);
		TextBox console = new TextBox();
		engine.replaceButton(0, console);
		engine.Button(0).enable(true);
		engine.Button(0).setVisible(true);
		engine.Button(0).pos.setR(engine.displayWidth / 2, engine.displayHeight
				- engine.displayHeight / 90);
		engine.Button(0)
				.setSize(engine.displayWidth, engine.displayHeight / 45);
		engine.Button(0).replaceText("Console initialisée");
		devInterface.addButton(engine.Button(0), 0);

		// Création d'un bouton affichant les fps
		engine.addButton(1);
		engine.Button(1).enable(true);
		engine.Button(1).setVisible(true);
		engine.Button(1).pos.setR(engine.displayWidth / 90,
				engine.displayHeight / 90);
		engine.Button(1).setSize(engine.displayWidth / 45,
				engine.displayHeight / 45);
		devInterface.addButton(engine.Button(1), 1);

		// Création d'un bouton affichant la révision du moteur/jeu
		engine.addButton(2);
		engine.Button(2).enable(true);
		engine.Button(2).setVisible(true);
		engine.Button(2).pos.setR(engine.displayWidth - engine.displayWidth
				/ 50, engine.displayHeight / 90);
		engine.Button(2).setSize(engine.displayWidth / 25,
				engine.displayHeight / 45);
		engine.Button(2).replaceText(engine.rev);
		devInterface.addButton(engine.Button(2), 2);

		// Création de l'entité représentant le joueur 1
		engine.addPlayer(0);
		engine.heightManager.setHeight(0, "Player", 0);
		Monstre pirate = new Monstre();
		engine.replacePlayer(0, pirate);
		engine.Player(0).enable(true);
		engine.Player(0).setVisible(true);
		engine.Player(0).pos.setR((int) (Math.random() * engine.displayWidth),
				(int) (Math.random() * engine.displayHeight));
		engine.Player(0).setSpriteId(0);
		engine.Player(0).setUpKey(90);
		engine.Player(0).setDownKey(83);
		engine.Player(0).setLeftKey(81);
		engine.Player(0).setRightKey(68);

		// Création de l'entité représentant le joueur 2
		engine.addPlayer(1);
		engine.heightManager.setHeight(0, "Player", 1);
		engine.Player(1).enable(true);
		engine.Player(1).setVisible(true);
		engine.Player(1).pos.setR(engine.displayWidth / 2,
				engine.displayHeight / 2);
		engine.Player(1).setSpriteId(1);
		engine.Player(1).setUpKey(38);
		engine.Player(1).setDownKey(40);
		engine.Player(1).setLeftKey(37);
		engine.Player(1).setRightKey(39);

		// Génération de murs d'ombre
		engine.addItem(0);
		Ombre mur1 = new Ombre();
		engine.replaceItem(0, mur1);
		mur1.setSpriteId(8);
		mur1.getPos().set(10, 6);
		mur1.enable(true);
		mur1.setVisible(true);

		engine.addItem(1);
		Ombre mur2 = new Ombre();
		engine.replaceItem(1, mur2);
		mur2.setSpriteId(8);
		mur2.getPos().set(10, 9);
		mur2.enable(true);
		mur2.setVisible(true);

		engine.addItem(2);
		Ombre mur3 = new Ombre();
		engine.replaceItem(2, mur3);
		mur3.setSpriteId(8);
		mur3.getPos().set(12, 6);
		mur3.enable(true);
		mur3.setVisible(true);

		engine.addItem(3);
		Ombre mur4 = new Ombre();
		engine.replaceItem(3, mur4);
		mur4.setSpriteId(8);
		mur4.getPos().set(12, 9);
		mur4.enable(true);
		mur4.setVisible(true);

		// Création de l'interface du menu de jeu
		engine.setInterfaceAmount(2);
		engine.addInterface(1);
		Interface menu = new Interface();
		engine.replaceInterface(1, menu);

		// Création d'un bouton Permettant de quitter le jeu
		engine.addButton(3);
		QuitButton quitter = new QuitButton();
		engine.replaceButton(3, quitter);
		quitter.replaceText("Quitter");
		quitter.pos.setR(engine.displayWidth / 2 - engine.displayWidth / 50,
				engine.displayHeight / 2 - engine.displayHeight / 90);
		quitter.setSize(engine.displayWidth / 25, engine.displayHeight / 45);
		menu.addButton(quitter, 0);

		// Création d'un bouton Permettant de lancer le jeu ou de quitter la
		// pause
		engine.addButton(4);
		PlayButton jouer = new PlayButton();
		engine.replaceButton(4, jouer);
		jouer.replaceText("Jouer");
		jouer.pos.setR(engine.displayWidth / 2 - engine.displayWidth / 50,
				engine.displayHeight / 2 - 32 - engine.displayHeight / 90);
		jouer.setSize(engine.displayWidth / 25, engine.displayHeight / 45);
		menu.addButton(jouer, 1);

		// Création d'un bouton pour tester l'utilisation de boutons représentés
		// par des images
		engine.addButton(5);
		SpriteButton dah = new SpriteButton();
		engine.replaceButton(5, dah);
		dah.pos.setR(engine.displayWidth / 2 - engine.displayWidth / 50,
				engine.displayHeight / 2 - 64 - engine.displayHeight / 90);
		dah.setSpriteId(9);
		menu.addButton(dah, 2);

		menu.enable(false);
		menu.setVisible(false);

		// Géneration et Positionnement aléatoire des entitées de test
		for (int id = 0; id < engine.npcAmount; id++) {
			engine.addNpc(id);
			engine.Npc(id).enable(true);
			engine.Npc(id).setVisible(true);

			engine.Npc(id).pos.setR(Math.random() * engine.screenWidth,
					Math.random() * engine.screenHeight);

			engine.Npc(id).setSpriteId(2);

		}

		// Définition de la représentation du curseur par défaut et du curseur
		// de click
		engine.cursor.setCursorSprite(engine.Sprite(6));
		engine.cursor.setClickSprite(engine.Sprite(7));

		// Création d'un délai éliminant des erreurs dans l'activation du menu
		// de jeu
		Timer pauseDelay = new Timer();
		pauseDelay.setDelay((long) 2.5E8);

		// Lancement du moteur
		engine.start();
		while (true) {
			if (engine.keyboard.keyP(27) && pauseDelay.ended()) {
				pauseDelay.start();
				if (engine.state == "Pause") {
					engine.state = "Resume";
				} else {
					engine.state = "Pause";
				}

				menu.enable(!menu.isEnabled());
				menu.setVisible(!menu.isVisible());
				engine.heightManager.setHeight(0, "Interface", 1);
			}
			engine.Button(1).replaceText(String.valueOf(engine.shownFps));
			engine.update();
		}
	}
}
