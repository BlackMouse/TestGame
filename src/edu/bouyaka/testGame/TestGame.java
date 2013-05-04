package edu.bouyaka.testGame;

import edu.bouyaka.engine.*;
import edu.bouyaka.engine.concreted.*;
import edu.bouyaka.engine.abstracted.*;

public class TestGame {

	public static Gengine engine;

	public static void main(String[] args) throws InterruptedException {
		
		// Initialisation du moteur
		engine = new Gengine();

		/*
		 * Initialisation et configuration des diffï¿½rents objets de base
		 */

		// Chargement des fichiers de configuration
		SysConfig basic = new SysConfig("base.cfg", engine);
		SpritesConfig spritesId = new SpritesConfig("spritesId.cfg", engine);

		// Lecture de la configuration
		basic.load();
		spritesId.load();

		// Crï¿½ation d'une interface affichant les informations importantes pour
		// le dï¿½veloppement
		engine.addInterface(0);
		Interface devInterface = new Interface();
		engine.replaceInterface(0, devInterface);
		devInterface.enable(true);
		devInterface.setVisible(true);
		devInterface.setHeightLevel(5);

		// Crï¿½ation d'un bouton affichant la console
		engine.addButton(0);
		TextBox console = new TextBox();
		engine.replaceButton(0, console);
		engine.Button(0).enable(true);
		engine.Button(0).setVisible(true);
		engine.Button(0).pos.setR(engine.displayWidth / 2, engine.displayHeight
				- engine.displayHeight / 90);
		engine.Button(0)
				.setSize(engine.displayWidth, engine.displayHeight / 45);
		engine.Button(0).replaceText("Console initialisï¿½e");
		devInterface.addButton(engine.Button(0), 0);

		// Crï¿½ation d'un bouton affichant les fps
		engine.addButton(1);
		engine.Button(1).enable(true);
		engine.Button(1).setVisible(true);
		engine.Button(1).pos.setR(engine.displayWidth / 90,
				engine.displayHeight / 90);
		engine.Button(1).setSize(engine.displayWidth / 45,
				engine.displayHeight / 45);
		devInterface.addButton(engine.Button(1), 1);

		// Crï¿½ation d'un bouton affichant la rï¿½vision du moteur/jeu
		engine.addButton(2);
		engine.Button(2).enable(true);
		engine.Button(2).setVisible(true);
		engine.Button(2).pos.setR(engine.displayWidth - engine.displayWidth
				/ 50, engine.displayHeight / 90);
		engine.Button(2).setSize(engine.displayWidth / 25,
				engine.displayHeight / 45);
		engine.Button(2).replaceText(engine.rev);
		devInterface.addButton(engine.Button(2), 2);
		
		// Ajout du son
		Sound background = new Sound("sounds/bg.wav");
		background.loop(true);
		background.play();
		
		// Création du fond
		int i = 4;
		for(double y = 0.5 ; y < engine.nVTiles ; y++) {
			for(double x = 0.5 ; x < engine.nHTiles ; x++) {
				engine.addItem(i);
				// Lumiere Item(i) = new Lumiere();
				engine.Item(i).enable(true);
				engine.Item(i).setVisible(true);
				engine.Item(i).pos.set(x,y);
				engine.Item(i).setSprite(engine.Sprite(5));
				engine.Item(i).collisionEnabled = false;
				engine.Item(i).setHeightLevel(4);
				i++;
			}
		}

		// Crï¿½ation de l'entitï¿½ reprï¿½sentant le joueur 0
		engine.addPlayer(0);
		Monstre pirate = new Monstre();
		engine.replacePlayer(0, pirate);
		engine.Player(0).enable(true);
		engine.Player(0).setVisible(true);
		engine.Player(0).pos.setR((int) (Math.random() * engine.displayWidth),
				(int) (Math.random() * engine.displayHeight));
		engine.Player(0).setSprite(engine.Sprite(0));
		pirate.setHeightLevel(5);
		engine.Player(0).setUpKey(38);
		engine.Player(0).setDownKey(40);
		engine.Player(0).setLeftKey(37);
		engine.Player(0).setRightKey(39);
		
		// Définition de la trajectoire du joueur 0
		Trajectory ligne = new Trajectory();
		Vector[] AB = new Vector[4];
		AB[0] = new Vector();
		AB[1] = new Vector();
		AB[2] = new Vector();
		AB[3] = new Vector();
		AB[0].set(10, 10);
		AB[1].set(25, 10);
		AB[2].set(25, 3);
		AB[3].set(3, 10);
		ligne.define(AB);
		ligne.loop(true);
		engine.Player(0).followTrajectory(ligne);

		// Crï¿½ation de l'entitï¿½ reprï¿½sentant le joueur 1
		engine.addPlayer(1);
		engine.Player(1).setHeightLevel(5);
		engine.Player(1).enable(true);
		engine.Player(1).setVisible(true);
		engine.Player(1).pos.setR(engine.displayWidth / 2,
				engine.displayHeight / 2);
		engine.Player(1).setSprite(engine.Sprite(1));
		engine.Player(1).setUpKey(90);
		engine.Player(1).setDownKey(83);
		engine.Player(1).setLeftKey(81);
		engine.Player(1).setRightKey(68);
		
		// Gï¿½nï¿½ration de murs d'ombre
		engine.addItem(0);
		Ombre mur0 = new Ombre();
		engine.replaceItem(0, mur0);
		mur0.setSprite(engine.Sprite(5));
		mur0.getPos().set(10.5, 6.5);
		mur0.enable(true);
		mur0.setVisible(true);
		mur0.setHeightLevel(3);

		engine.addItem(1);
		Ombre mur1 = new Ombre();
		engine.replaceItem(1, mur1);
		mur1.setSprite(engine.Sprite(5));
		mur1.getPos().set(10.5, 7.5);
		mur1.enable(true);
		mur1.setVisible(true);
		mur1.setHeightLevel(3);

		engine.addItem(2);
		Ombre mur2 = new Ombre();
		engine.replaceItem(2, mur2);
		mur2.setSprite(engine.Sprite(5));
		mur2.getPos().set(11.5, 6.5);
		mur2.enable(true);
		mur2.setVisible(true);
		mur2.setHeightLevel(3);

		engine.addItem(3);
		Ombre mur3 = new Ombre();
		engine.replaceItem(3, mur3);
		mur3.setSprite(engine.Sprite(5));
		mur3.getPos().set(12.5, 6.5);
		mur3.enable(true);
		mur3.setVisible(true);
		mur3.setHeightLevel(3);

		engine.addItem(4);
		Ombre mur4 = new Ombre();
		engine.replaceItem(3, mur4);
		mur4.setSprite(engine.Sprite(5));
		mur4.getPos().set(11.5, 7.5);
		mur4.enable(true);
		mur4.setVisible(true);
		mur4.setHeightLevel(3);

		engine.addItem(5);
		Ombre mur5 = new Ombre();
		engine.replaceItem(3, mur5);
		mur5.setSprite(engine.Sprite(5));
		mur5.getPos().set(12.5, 7.5);
		mur5.enable(true);
		mur5.setVisible(true);
		mur5.setHeightLevel(3);

		// Affichage du sprite des mur
		engine.addItem(6);
		Ombre spriteMur = new Ombre();
		engine.replaceItem(6, spriteMur);
		spriteMur.enable(true);
		spriteMur.setSprite(engine.Sprite(18));
		spriteMur.pos.setR(440.5, 260.5);
		spriteMur.setVisible(true);
		spriteMur.setHeightLevel(5);
		
		// Crï¿½ation de l'interface du menu de jeu
		engine.setInterfaceAmount(2);
		engine.addInterface(1);
		Interface menu = new Interface();
		engine.replaceInterface(1, menu);

		// Crï¿½ation d'un bouton Permettant de quitter le jeu
		engine.addButton(3);
		QuitButton quitter = new QuitButton();
		engine.replaceButton(3, quitter);
		quitter.replaceText("Quitter");
		quitter.pos.setR(engine.displayWidth / 3 + 100,
				engine.displayHeight / 2 + 100);
		quitter.setSprite(engine.Sprite(12));
		quitter.setSize(engine.displayWidth / 50, engine.displayHeight / 50);
		menu.addButton(quitter, 0);
		quitter.setHeightLevel(7);

		// Crï¿½ation d'un bouton Permettant de lancer le jeu ou de quitter la
		// pause
		engine.addButton(4);
		PlayButton jouer = new PlayButton();
		engine.replaceButton(4, jouer);
		jouer.replaceText("Jouer");
		jouer.pos.setR(engine.displayWidth * 2 / 3 - 100,
				engine.displayHeight / 2 + 100);
		jouer.setSprite(engine.Sprite(10));
		jouer.setSize(engine.displayWidth / 50, engine.displayHeight / 50);
		menu.addButton(jouer, 1);
		jouer.setHeightLevel(7);

		// Gï¿½neration et Positionnement alï¿½atoire des entitï¿½es de test
		for (int id = 0; id < engine.npcAmount; id++) {
			engine.addNpc(id);
			engine.Npc(id).enable(true);
			engine.Npc(id).setVisible(true);

			engine.Npc(id).pos.setR(Math.random() * engine.screenWidth,
					Math.random() * engine.screenHeight);

			engine.Npc(id).setSprite(engine.Sprite(2));
			engine.Npc(id).setHeightLevel(4);
		}

		// Dï¿½finition de la reprï¿½sentation du curseur par dï¿½faut et du curseur
		// de click
		engine.cursor.setCursorSprite(engine.Sprite(6));
		engine.cursor.setClickSprite(engine.Sprite(7));

		// Crï¿½ation d'un dï¿½lai ï¿½liminant des erreurs dans l'activation du menu
		// de jeu
		Timer pauseDelay = new Timer();
		pauseDelay.setDelay((long) 2.5E8);

		// Création du boutton du fond
		engine.addButton(5);
		SpriteButton titre = new SpriteButton();
		engine.replaceButton(5, titre);
		menu.addButton(titre, 2);
		
		
		// Variables fondamentale
		boolean win = false;
		
		// Lancement du moteur
		engine.start();
		
		engine.state = "Pause";
		
		menu.enable(true);
		menu.setVisible(true);
		
		titre.enable(true);
		titre.setSprite(engine.Sprite(17));
		titre.pos.setR(engine.displayWidth / 2,
				engine.displayHeight / 2);
		titre.setSize(engine.displayWidth, engine.displayHeight);
		titre.setHeightLevel(6);
		
		while (true) {
			
			// Définition des points à atteindre par le joueur 1
			Trajectory position = new Trajectory();
			Vector[] PS = new Vector[1];
			
			if(engine.cursor.getCButton(1)) {			
				if(engine.cursor.getLastC().getDistanceTo(engine.Player(1).pos) > 1) {
					PS[0] = engine.cursor.getLastC();
					position.define(PS);
					position.loop(false);
					engine.Player(1).followTrajectory(position);
				}
			}			
			if (engine.keyboard.keyP(engine.Player(1).getLeftKey())
					|| engine.keyboard.keyP(engine.Player(1).getRightKey())
					|| engine.keyboard.keyP(engine.Player(1).getUpKey())
					|| engine.keyboard.keyP(engine.Player(1).getDownKey())) {
				engine.Player(1).stopFollowingTrajectory();
				position = null;
				PS = null;
			}
			
			// Définition du mode du jeu
			if (engine.keyboard.keyP(27) && pauseDelay.ended()) {
				pauseDelay.start();
				if (engine.state == "Pause") {
					engine.state = "Resume";
				} else {
					engine.state = "Pause";
					
					// Affichage du boutton fond
					titre.enable(!titre.isEnabled());
					titre.setSprite(engine.Sprite(17));
					titre.pos.setR(engine.displayWidth / 2,
							engine.displayHeight / 2);
					titre.setSize(engine.displayWidth, engine.displayHeight);
					titre.setHeightLevel(6);
				}
				
				menu.enable(!menu.isEnabled());
				menu.setVisible(!menu.isVisible());
			} else {
				engine.Button(1).replaceText(String.valueOf(engine.shownFps));
				engine.update();
			}
			
			// But du jeu !
			if (engine.collision.areColliding((Entity) engine.Player(0), (Entity) engine.Player(1)) && win == false) {
				engine.Player(0).enable(false);
				engine.Player(0).setVisible(false);
				
				engine.state = "Pause";
				
				menu.enable(true);
				menu.setVisible(true);
				
				titre.enable(true);
				titre.setSprite(engine.Sprite(17));
				titre.pos.setR(engine.displayWidth / 2,
						engine.displayHeight / 2);
				titre.setSize(engine.displayWidth, engine.displayHeight);
				titre.setHeightLevel(6);
				
				win = true;
			}

		}
	}
}
