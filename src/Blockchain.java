import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class Blockchain {

    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 6;

    public static void main(String[] args) {
        blockchain.add(new Block("First block", "0"));
        System.out.println("Trying to Mine block 1... ");
        blockchain.getFirst().mineBlock(difficulty);

        blockchain.add(new Block("Second block", blockchain.getLast().hash));
        System.out.println("Trying to Mine block 2... ");
        blockchain.get(1).mineBlock(difficulty);

        blockchain.add(new Block("Third block", blockchain.getLast().hash));
        System.out.println("Trying to Mine block 3... ");
        blockchain.get(2).mineBlock(difficulty);

        System.out.println("Is blockchain valid : " + validateBlockchain());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);
    }

    public static Boolean validateBlockchain() {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            if (!currentBlock.hash.equals(currentBlock.calculateHash())){
                System.out.println("Current Hashes not equal");
                return false;
            }

            if (!previousBlock.hash.equals(currentBlock.previousHash)){
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }

        return true;

    }
}
