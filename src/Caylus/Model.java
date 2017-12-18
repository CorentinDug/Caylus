package Caylus;

import Caylus.Batiment.Batiment;
import Caylus.Batiment.Neutre.*;
import Caylus.Batiment.Speciaux.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;


/**
 * Created by Schnoeby on 19/11/2017.
 */
public class Model {
    private View view;

    protected int nbrJoueurs;
    protected int noPhase;
    protected int coutDePose;
    protected boolean decompteDonjon;
    protected boolean decompteMuraille;
    protected boolean decompteTour;

    protected Chateau chateau;
    protected Prévot prévot;
    protected Baillis baillis;
    public Joueur[] listeJoueur;
    private ArrayList<Joueur> finDePose;
    private ArrayList<Joueur> ordreDeTour;
    private ArrayList<Joueur> ordreDeTourOrigine;
    private ArrayList<Joueur> ordreDePhase2;


    protected ArrayList<Batiment> batSpeciaux;
    protected ArrayList<Batiment> batNeutre;


    private Color[] couleur;

    protected Case[] cases;

    protected String[] Ressources;

    /**
     * Constructeur intialise le model et le nombre de joueur
     * @param nbrJoueur nobmre de joueur dans la partie
     */
    public Model(int nbrJoueur) {
        noPhase = 0;
        chateau = new Chateau();
        nbrJoueurs = nbrJoueur;
        prévot = new Prévot();
        baillis = new Baillis();
        listeJoueur = new Joueur[nbrJoueur];

        Ressources = new String[]{"denier", "nourriture", "tissu", "bois", "pierre", "or"};
        initBatiment();
        initCouleur();
        initCases();
        decompteDonjon = false;
        decompteMuraille = false;
        decompteTour = false;
    }

    /**
     * Récupère le nom du joueur en fonction de son index dans la liste des joueurs
     * @param i position de joueur dans la liste
     * @return le nom
     */
    public String getNom(int i) {
        int n = i - 1;
        if (listeJoueur[n] != null)
            return listeJoueur[n].getNom();
        return "Joueur" + i;
    }

    /**
     * Récupère le nombre de denier du joueur en fonction de son index dans la liste des joueurs
     * @param i position de joueur dans la liste
     * @return le nombre de denier
     */
    public int getDenier(int i) {
        int n = i - 1;
        if (listeJoueur[n] != null)
            return listeJoueur[n].getDenier();
        return 0;
    }

    /**
     * Récupère le nombre d'or du joueur en fonction de son index dans la liste des joueurs
     * @param i position de joueur dans la liste
     * @return le nombre d'or
     */
    public int getOr(int i) {
        int n = i - 1;
        if (listeJoueur[n] != null)
            return listeJoueur[n].getOr();
        return 0;
    }

    /**
     * Récupère le nombre de nourriture du joueur en fonction de son index dans la liste des joueurs
     * @param i position de joueur dans la liste
     * @return le nombre de nourriture
     */
    public int getNourriture(int i) {
        int n = i - 1;
        if (listeJoueur[n] != null)
            return listeJoueur[n].getNourriture();
        return 0;
    }

    /**
     * Récupère le nombre de pierre du joueur en fonction de son index dans la liste des joueurs
     * @param i position de joueur dans la liste
     * @return le nombre de pierre
     */
    public int getPierre(int i) {
        int n = i - 1;
        if (listeJoueur[n] != null)
            return listeJoueur[n].getPierre();
        return 0;
    }

    /**
     * Récupère le nombre de bois du joueur en fonction de son index dans la liste des joueurs
     * @param i position de joueur dans la liste
     * @return le nombre de bois
     */
    public int getBois(int i) {
        int n = i - 1;
        if (listeJoueur[n] != null)
            return listeJoueur[n].getBois();
        return 0;
    }

    /**
     * Récupère le nombre de tissu du joueur en fonction de son index dans la liste des joueurs
     * @param i position de joueur dans la liste
     * @return le nombre de tissu
     */
    public int getTissu(int i) {
        int n = i - 1;
        if (listeJoueur[n] != null)
            return listeJoueur[n].getTissu();
        return 0;
    }

    /**
     * Récupère la couleur du joueur en fonction de son index dans la liste des joueurs
     * @param i position de joueur dans la liste
     * @return la couleur du joueur
     */
    public Color getColor(int i) {
        int n = i - 1;
        if (listeJoueur[n] != null)
            return listeJoueur[n].getCouleur();
        return null;
    }

    /**
     * Récupère le score joueur en fonction de son index dans la liste des joueurs
     * @param i position de joueur dans la liste
     * @return le score du joueur
     */
    public int getPrestige(int i) {
        int n = i - 1;
        if (listeJoueur[n] != null)
            return listeJoueur[n].getPrestige();
        return 0;
    }

    /**
     * Intialise les couleurs utiliser pour les joueurs
     */
    public void initCouleur() {
        couleur = new Color[5];
        couleur[0] = Color.blue;
        couleur[1] = Color.red;
        couleur[2] = Color.green;
        couleur[3] = Color.orange;
        couleur[4] = Color.black;
    }

    /**
     * Initialise les batiments qui sont de base sur le plateau
     */
    public void initBatiment() {
        batNeutre = new ArrayList<>();
        batNeutre.add(new NCarriere());
        batNeutre.add(new NCharpentier());
        batNeutre.add(new NFerme());
        batNeutre.add(new NForet());
        batNeutre.add(new NMarche());
        batNeutre.add(new NScierie());

        batSpeciaux = new ArrayList<>();
        batSpeciaux.add(new Porte());
        batSpeciaux.add(new Comptoir());
        batSpeciaux.add(new DeplPrevot());
        batSpeciaux.add(new Joute());
        batSpeciaux.add(new Ecurie());
        batSpeciaux.add(new Auberge());


        Collections.shuffle(batNeutre);
    }

    /**
     * Initialise les cases avec les batiments correspondant
     */
    public void initCases() {
        cases = new Case[34];
        for (int i = 0; i < 34; i++) {
            cases[i] = new Case();
        }
        int n = 0;
        for (int i = 0; i < 6; i++) {
            cases[i].setBatiment(batSpeciaux.get(n++));
        }
        n = 0;
        for (int i = 6; i < 12; i++) {
            cases[i].setBatiment(batNeutre.get(n++));
        }
    }

    /**
     * Associe chaque joueur à une couleur, place mélange les batiments neutre et créé l'ordre de tour
     */
    public void initJoueur() {
        ordreDeTour = new ArrayList<Joueur>();
        ordreDeTourOrigine = new ArrayList<Joueur>();
        for (int i = 0; i < nbrJoueurs; i++) {
            String nom = view.créerJoueur(i + 1);
            Joueur joueur = new Joueur(nom);
            joueur.setCouleur(couleur[i]);
            listeJoueur[i] = joueur;
            view.editPJoueur();
        }

        for (Joueur joueur : listeJoueur) {
            ordreDeTour.add(joueur);
        }

        Collections.shuffle(ordreDeTour);
        ordreDeTourOrigine.addAll(ordreDeTour);
        Collections.shuffle(batNeutre);

    }

    /**
     * @return Le message à afficher dans le panneau de droite en fonction de la phase
     */
    public String getPhase() {
        if (noPhase == 1)
            return "Perception des revenues";
        if (noPhase == 2)
            return "Placement des ouvriers";
        if (noPhase == 3)
            return "L’activation des bâtiment spéciaux";
        if (noPhase == 4)
            return "Déplacement du prévôt";
        if (noPhase == 5)
            return "L’activation des bâtiments";
        if (noPhase == 6)
            return "Construction du château";
        if (noPhase == 7)
            return "Fin de tour";
        return "Initialisation des ressources";
    }

    /**
     * @return Le message à afficher dans le panneau de droite en fonction de la phase
     */
    public String getInfoPhase() {
        if (noPhase == 2)
            return "Le cout est de " + coutDePose + " deniers";
        return "";
    }

    /**
     * @return Le joueur à afficher dans le panneau de droite en fonction de la phase
     */
    public String getTourJoueur() {
        if (noPhase == 2)
            if (!ordreDePhase2.isEmpty())
                return ordreDePhase2.get(0).getNom();
        return "";

    }

    /**
     * Retourne le batiment associé à la case
     * @param coordonnee coordonnée de la case
     * @return le batiment
     */
    public Batiment getBatiment(int coordonnee) {
        return cases[coordonnee].getBatiment();
    }

    /**
     * Associe la vue au model
     * @param vue la vue à associer
     */
    public void setView(View vue) {
        this.view = vue;
        view.setPrévot(prévot.coordonnée);
        view.setBaillis(baillis.coordonnée);
        view.initImageCase();

    }

    /**
     * Initialise les ressource de début de jeu
     */
    public void initRessource() {
        //changer label info
        int compteurJoueur = 0;
        for (Joueur joueur : listeJoueur) {
            joueur.recoit("nourriture", 2);
            joueur.recoit("bois", 1);
            if (compteurJoueur == 0)
                joueur.recoit("denier", 5);
            else if (compteurJoueur == 1 || compteurJoueur == 2)
                joueur.recoit("denier", 6);
            else
                joueur.recoit("denier", 7);
            compteurJoueur++;

        }
        noPhase++;
        view.editPJoueur();
    }

    /**
     * Distribue des ressources en fonction des propriétés des joueurs
     */
    public void phase1() {
        view.editPInfo();
        int revenue;
        for (Joueur joueur : listeJoueur) {
            revenue = 2;
            for (Batiment propriété : joueur.propriété) {
                if (propriété.getNom().equals("Residence"))
                    revenue++;
                if (propriété.getNom().equals("Bibliothèque"))
                    revenue++;
                if (propriété.getNom().equals("Hotel"))
                    revenue += 2;
            }
            joueur.recoit("denier", revenue);
        }
        view.editPJoueur();
        coutDePose = 1;
        ordreDePhase2 = new ArrayList<Joueur>();
        finDePose = new ArrayList<Joueur>();
        ordreDeTour = new ArrayList<Joueur>();
        ordreDeTour.addAll(ordreDeTourOrigine);
    }

    /**
     * Initialise l'ordre de pose d'ouvrier
     */
    public void phase2() {
        if (ordreDePhase2.isEmpty())
            ordreDePhase2.addAll(ordreDeTour);
    }

    /**
     * Ajoute un joueur en constructeur du chateau
     */
    public void constChateau() {
        Joueur joueur = ordreDePhase2.get(0);
        int coordonnée = chateau.ajouterConstructeur(joueur);
        if (coordonnée != -1) {
            if (joueur.getOuvrier() != 0) {
                if (joueur.donne("denier", coutDePose) || (cases[5].getBatiment().getOuvrier(2) == joueur && joueur.donne("denier", 1))) {
                    joueur.poseOuvrier();
                    ordreDePhase2.remove(0);
                    view.constChateau(coordonnée, joueur);
                } else {
                    chateau.ordreConstruction.remove(joueur);
                    view.problèmeOuvrier(joueur.getNom(), -4);
                }
            } else {
                chateau.ordreConstruction.remove(joueur);
                view.problèmeOuvrier(joueur.getNom(), -2);
            }
        } else {
            chateau.ordreConstruction.remove(joueur);
            view.problèmeChateau(joueur.getNom());
        }
        phase2();
        view.editPInfo();
        view.editPJoueur();
    }

    /**
     * Ajoute un joueur en tant qu'ouvrier sur un batiment
     * @param coordonnee coordonnée du batiment
     */
    public void poseOuvrier(int coordonnee) {
        Joueur joueur = ordreDePhase2.get(0);
        if (joueur.getDenier() >= coutDePose || (cases[5].getBatiment().getOuvrier(2) == joueur && joueur.getDenier() >= 1)) {
            if (getBatiment(coordonnee) != null) {
                if (joueur.getOuvrier() != 0) {
                    if (getBatiment(coordonnee).engager(joueur)) {
                        if (cases[5].getBatiment().getOuvrier(2) != joueur)
                            joueur.donne("denier", coutDePose);
                        else
                            joueur.donne("denier", 1);

                        joueur.poseOuvrier();
                        ordreDePhase2.remove(0);
                        view.poserOuvrier(coordonnee, joueur);
                    } else {
                        view.problèmeOuvrier(joueur.getNom(), -3);
                    }
                } else {
                    view.problèmeOuvrier(joueur.getNom(), -2);
                }
            } else {
                view.problèmeOuvrier(joueur.getNom(), -1);
            }
        } else {
            view.problèmeOuvrier(joueur.getNom(), -4);
        }
        phase2();
        view.editPInfo();
        view.editPJoueur();
    }

    /**
     * retire un joueur de l'ordre de pose
     */
    public void joueurPasse() {
        if (finDePose.isEmpty())
            ordreDePhase2.get(0).recoit("denier", 1);
        finDePose.add(ordreDePhase2.get(0));
        ordreDeTour.remove(ordreDePhase2.get(0));
        ordreDePhase2.remove(0);
        coutDePose++;
        if (ordreDeTour.isEmpty())
            noPhase++;
        phase2();
        view.editPJoueur();
        view.editPInfo();
    }

    /**
     * Active les batiments spéciaux si un ouvrier est dessus
     */
    public void phase3() {
        view.editPInfo();
        Joueur ouvrier;
        ArrayList<Joueur> newOrdre;
        ArrayList<Joueur> newOrdre2;
        for (int i = 0; i <= 5; i++) {
            ouvrier = cases[i].getOuvrier();
            if (cases[i].getBatiment() != null) {
                if (ouvrier != null) {
                    int index = cases[i].getBatiment().active(view);
                    ouvrier.reprendOuvrier();

                    if (index == -1 || index == -2 || index == -3)
                        view.problèmeActivation(index, ouvrier.getNom(), cases[i].getNomProprio());

                    if (index == 1) {
                        int coordonné = view.panneauPorte(ouvrier.getNom());
                        if (ouvrier.getOuvrier() != 0) {
                            if (getBatiment(coordonné).engager(ouvrier)) {
                                view.poserOuvrier(coordonné, ouvrier);
                            } else {
                                view.problèmeOuvrier(ouvrier.getNom(), -3);
                            }
                        } else {
                            view.problèmeOuvrier(ouvrier.getNom(), -2);
                        }
                    }

                    if (index == 3) {
                        int rang = -1;
                        int coordonnée = -1;
                        rang = view.deplPrevot(cases[i].getOuvrier());
                        switch (rang) {
                            case 0:
                                coordonnée = prévot.getCoordonnée() - 3;
                                break;
                            case 1:
                                coordonnée = prévot.getCoordonnée() - 2;
                                break;
                            case 2:
                                coordonnée = prévot.getCoordonnée() - 1;
                                break;
                            case 3:
                                coordonnée = prévot.getCoordonnée();
                                break;
                            case 4:
                                coordonnée = prévot.getCoordonnée() + 1;
                                break;
                            case 5:
                                coordonnée = prévot.getCoordonnée() + 2;
                                break;
                            case 6:
                                coordonnée = prévot.getCoordonnée() + 3;
                                break;
                        }
                        if (coordonnée < 6)
                            coordonnée = 6;
                        if (coordonnée > 33)
                            coordonnée = 33;
                        view.setPrévot(coordonnée);
                        prévot.coordonnée = coordonnée;
                    }

                    if (index == 5) {
                        newOrdre = new ArrayList<Joueur>();
                        newOrdre2 = new ArrayList<Joueur>();
                        newOrdre2.addAll(ordreDeTourOrigine);
                        newOrdre.add(cases[i].getBatiment().getOuvrier(1));
                        if(cases[i].getBatiment().getOuvrier(2)!=null)
                            newOrdre.add(cases[i].getBatiment().getOuvrier(2));
                        if(cases[i].getBatiment().getOuvrier(3)!=null)
                            newOrdre.add(cases[i].getBatiment().getOuvrier(3));
                        for (Joueur joueur : ordreDeTourOrigine) {
                            for (Joueur joueurOrdre : newOrdre) {
                                if (joueur == joueurOrdre)
                                    newOrdre2.remove(joueurOrdre);
                            }
                        }
                        newOrdre.addAll(newOrdre2);
                        ordreDeTourOrigine = new ArrayList<Joueur>();
                        ordreDeTourOrigine.addAll(newOrdre);
                    }

                    if (index == 6) {
                        view.poserOuvrier(5, ouvrier);
                    }




                    cases[i].getBatiment().retireOuvrier();
                    view.editImageCase();
                    view.retireOuvrier(i);
                    view.editPJoueur();
                    view.editPInfo();
                }
            }
        }

        noPhase++;
    }

    /**
     * Demande à chaque joueur si il veut déplacer le prévot et de combien de cases
     */
    public void phase4() {
        view.editPInfo();
        int rang;
        int coordonnée = -1, cout = -1;
        for (Joueur joueur : finDePose) {
            rang = view.deplPrevot(joueur);
            switch (rang) {
                case 0:
                    coordonnée = prévot.getCoordonnée() - 3;
                    cout = 3;
                    break;
                case 1:
                    coordonnée = prévot.getCoordonnée() - 2;
                    cout = 2;
                    break;
                case 2:
                    coordonnée = prévot.getCoordonnée() - 1;
                    cout = 1;
                    break;
                case 3:
                    coordonnée = prévot.getCoordonnée();
                    cout = 0;
                    break;
                case 4:
                    coordonnée = prévot.getCoordonnée() + 1;
                    cout = 1;
                    break;
                case 5:
                    coordonnée = prévot.getCoordonnée() + 2;
                    cout = 2;
                    break;
                case 6:
                    coordonnée = prévot.getCoordonnée() + 3;
                    cout = 3;
                    break;
            }
            if (coordonnée < 6)
                coordonnée = 6;
            if (coordonnée > 33)
                coordonnée = 33;
            if (joueur.getDenier() >= cout) {
                view.setPrévot(coordonnée);
                prévot.coordonnée = coordonnée;
                joueur.donne("denier", cout);
            } else {
                view.problèmeOuvrier(joueur.getNom(), -4);
            }
            view.editImageCase();
            view.editPJoueur();
            view.editPInfo();
        }
        noPhase++;
    }

    /**
     * Active tout les batiments situé avant le prévot
     */
    public void phase5() {
        view.editPInfo();
        Joueur ouvrier;
        String[] batResidence;
        ArrayList<String> batPossibleRes;
        for (int i = 6; i <= prévot.getCoordonnée(); i++) {
            batPossibleRes = new ArrayList<>();
            if (cases[i].getBatiment() != null) {
                if (cases[i].getOuvrier() != null) {
                    ouvrier = cases[i].getOuvrier();
                    int index = cases[i].getBatiment().active(view);
                    if (index == 0)
                        cases[i].getBatiment().retireOuvrier();
                    if (index == -1 || index == -2 || index == -3)
                        view.problèmeActivation(index, cases[i].getNomOuvrier(), cases[i].getNomProprio());

                    if (index == 10) {
                        for (Case caseVerif : cases) {
                            if (caseVerif.getBatiment() == null) {
                                caseVerif.setBatiment(ouvrier.dernierePropriete());
                                break;
                            }
                        }
                    }
                    if (index == 11) {
                        int m = -1;
                        cases[15] = new Case();
                        for (Case caseVerif : cases) {
                            if (caseVerif.getBatiment() != null)
                                if (caseVerif.getBatiment().isNeutre())
                                    batPossibleRes.add(caseVerif.getNomBat());
                        }
                        for (Batiment bat : ouvrier.propriété)
                            batPossibleRes.add(bat.getNom());

                        batResidence = new String[batPossibleRes.size()];
                        for (int j = 0; j < batPossibleRes.size(); j++)
                            batResidence[j] = batPossibleRes.get(j);

                        String batchoisis = view.choixConst(batResidence, cases[i].getNomOuvrier());
                        if (batchoisis != null) {
                            for (Case caseVerif : cases) {
                                if (caseVerif.getNomBat().equals(batchoisis))
                                    caseVerif.setBatiment(ouvrier.dernierePropriete());
                            }
                        } else {
                            view.problèmeActivation(-5, ouvrier.getNom(), null);
                            ouvrier.propriété.remove(ouvrier.propriété.size() - 1);
                        }
                    }
                    if (index == 12) {
                        int nbrRes = 1;
                        for (Case cases : cases) {
                            if (cases.getNomBat().equals("Residence"))
                                batPossibleRes.add(cases.getNomBat() + " " + nbrRes++);
                        }
                        batResidence = new String[batPossibleRes.size()];
                        for (int j = 0; j < batPossibleRes.size(); j++)
                            batResidence[j] = batPossibleRes.get(j);

                        String batchoisis = view.choixConst(batResidence, cases[i].getNomOuvrier());
                        if (batchoisis != null) {
                            nbrRes = 0;
                            for (Case caseVerif : cases) {
                                if (caseVerif.getNomBat().equals("Residence")) {
                                    nbrRes++;
                                    if (batchoisis.equals(caseVerif.getNomBat() + " " + nbrRes++))
                                        caseVerif.setBatiment(ouvrier.dernierePropriete());
                                }
                            }
                        } else {
                            view.problèmeActivation(-5, ouvrier.getNom(), null);
                            ouvrier.propriété.remove(ouvrier.propriété.size() - 1);
                        }
                    }
                    cases[i].getBatiment().retireOuvrier();
                    ouvrier.reprendOuvrier();
                    view.retireOuvrier(i);
                    view.editImageCase();
                    view.editPJoueur();
                    view.editPInfo();

                }
            }

        }
        for(int i =prévot.getCoordonnée();i<33;i++){
            if(cases[i].getBatiment()!=null)
                cases[i].getBatiment().retireOuvrier();
            view.retireOuvrier(i);
        }
        noPhase++;
    }

    /**
     * Effectue le décompte du donjon
     */
    public void decompteDonjon() {
        int[] compteurPartie = new int[nbrJoueurs];

        for (int i = 0; i < compteurPartie.length; i++)
            compteurPartie[i] = 0;


        decompteDonjon = true;
        for (int i = 0; i < listeJoueur.length; i++) {
            for (Joueur joueur : chateau.donjon) {
                if (listeJoueur[i] == joueur)
                    compteurPartie[i] += 1;
            }
        }
        for (int i = 0; i < listeJoueur.length; i++) {
            if (compteurPartie[i] >= 2)
                listeJoueur[i].recoit("or", 1);
            else if (compteurPartie[i] == 0)
                listeJoueur[i].donne("prestige", 2);
        }
    }

    /**
     * Effectue le décompte de la muraille
     */
    public void decompteMuraille(){
        int[] compteurPartie = new int[nbrJoueurs];

        for (int i = 0; i < compteurPartie.length; i++)
            compteurPartie[i] = 0;


        decompteMuraille=true;
        for(int i=0;i<listeJoueur.length;i++){
            for(Joueur joueur :chateau.muraille){
                if(listeJoueur[i]==joueur)
                    compteurPartie[i]+=1;
            }
        }
        for(int i=0;i<listeJoueur.length;i++){
            if(compteurPartie[i]>=2)
                listeJoueur[i].recoit("or",1);
            else if(compteurPartie[i]>=3)
                listeJoueur[i].recoit("or",2);
            else  if(compteurPartie[i]>=5)
                listeJoueur[i].recoit("or",3);
            else  if(compteurPartie[i]==0)
                listeJoueur[i].donne("prestige",3);
        }
    }

    /**
     * Effectue le décompte de la tour
     */
    public void decompteTour(){
        int[] compteurPartie = new int[nbrJoueurs];

        for (int i = 0; i < compteurPartie.length; i++)
            compteurPartie[i] = 0;


        decompteTour=true;
        for(int i=0;i<listeJoueur.length;i++){
            for(Joueur joueur :chateau.tour){
                if(listeJoueur[i]==joueur)
                    compteurPartie[i]+=1;
            }
        }

        for(int i=0;i<listeJoueur.length;i++){
            if(compteurPartie[i]>=2)
                listeJoueur[i].recoit("or",1);
            else if(compteurPartie[i]>=4)
                listeJoueur[i].recoit("or",2);
            else  if(compteurPartie[i]>=6)
                listeJoueur[i].recoit("or",3);
            else  if(compteurPartie[i]==0)
                listeJoueur[i].donne("prestige",4);
        }
    }


    /**
     * Permet de construire les parties du chateau en fonction de la liste des constructeur
     */
    public void phase6() {
        int[] compteurPartie = new int[chateau.ordreConstruction.size()];
        Joueur[] joueursConst = new Joueur[chateau.ordreConstruction.size()];

        int i = 0;
        for (Joueur joueursChateau : chateau.ordreConstruction) {
            joueursConst[i] = joueursChateau;
            i++;
        }
        view.editPInfo();
        i = 0;
        while (!chateau.ordreConstruction.isEmpty()) {
            compteurPartie[i] = chateau.constPartie(view);
            view.editPInfo();
            view.editChateau();
            i++;
        }
        view.retireOuvrierChateau();

        int valeurMax = -1;
        int indexMax = -1;
        for (i = 0; i < compteurPartie.length; i++) {
            if (compteurPartie[i] > valeurMax) {
                valeurMax = compteurPartie[i];
                indexMax = i;
            }
        }
        if(indexMax!=-1)
            joueursConst[indexMax].recoit("or", 1);

        if(chateau.donjon[5]!=null && !decompteDonjon)
            decompteDonjon();
        if(chateau.muraille[9]!=null && !decompteMuraille)
            decompteMuraille();

        if(chateau.tour[13]!=null && !decompteTour)
            decompteTour();

        noPhase++;
    }

    /**
     * Permet de désigner le vainqueur en fonction de son score
     * @return
     */
    public String vainqueur(){
        int prestigeMax=0;
        String vainqueur="";
        for (Joueur joueur : listeJoueur) {
            if (joueur.getPrestige() >= prestigeMax) {
                prestigeMax = joueur.getPrestige();
                vainqueur+="-"+joueur.getNom();
            }
        }
        return vainqueur;
    }


    /**
     * Vérifie si la partie est finis et distribue des récompense en fonction du nombre de partie de chateau construit
     */
    public void phase7() {
        view.editPInfo();

        int[] compteurPartie = new int[nbrJoueurs];

        for (int i = 0; i < compteurPartie.length; i++)
            compteurPartie[i] = 0;

        if (prévot.getCoordonnée() > baillis.getCoordonnée()){
            view.setBaillis(baillis.getCoordonnée() +2 );
            baillis.setCoordonnée(baillis.getCoordonnée() + 2);
            view.setPrévot(baillis.getCoordonnée());
            prévot.setCoordonnée(baillis.getCoordonnée());
        }else{
            baillis.setCoordonnée(baillis.getCoordonnée() + 1);

        }

        if (baillis.getCoordonnée() >= 17 && !decompteDonjon)
            decompteDonjon();

        if(baillis.getCoordonnée()>=23 && !decompteMuraille)
            decompteMuraille();

        if(baillis.getCoordonnée()>=29 && !decompteTour)
            decompteTour();

        if (decompteTour){
            noPhase++;
            view.finDuGame(vainqueur());
        }else {
            noPhase = 1;
        }
    }
}
