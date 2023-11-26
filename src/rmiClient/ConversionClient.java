package rmiClient;

import rmiService.IConversion;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ConversionClient {

    public static void main(String[] args) {


        try {
            // Recherche de l'objet distant dans le registre RMI
            IConversion stub = (IConversion) Naming.lookup("rmi://localhost:1099/ConversionObject");

            // Invite l'utilisateur à saisir un montant
            System.out.println("Donner le Montant :");
            Scanner scanner = new Scanner(System.in);
            double montant = scanner.nextDouble();

            // Appel de la méthode convertirMontant sur l'objet distant
            double montantConv = stub.convertirMontant(montant);

            // Affiche le montant original et le montant converti
            System.out.println("Montant avant conv:" + montant);
            System.out.println("\nMontant apres conv:" + montantConv);
        } catch (NotBoundException e) {
            // En cas d'erreur de liaison avec le service distant
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            // En cas d'URL mal formée
            throw new RuntimeException(e);
        } catch (RemoteException e) {
            // En cas d'erreur de communication avec le serveur RMI
            throw new RuntimeException(e);
        }
    }
}