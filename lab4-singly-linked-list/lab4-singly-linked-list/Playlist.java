public class Playlist {
    private static class Node {
        Song song;
        Node next;
        Node(Song song) { this.song = song; }
    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist() {
        head = null;
        tail = null;
        currentNode = null;
        size = 0;
    }

    public void addSong(Song song) {
        Node newNode = new Node(song);

        if (head == null) { // empty list
            head = newNode;
            tail = newNode;
            currentNode = null; // will start playing from head
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public boolean removeSong(String title) {
        if (head == null) return false;

        // case 1: removing head
        if (head.song.getTitle().equalsIgnoreCase(title)) {
            // if current is head, move current forward
            if (currentNode == head) currentNode = head.next;

            head = head.next;
            size--;

            // if list became empty
            if (head == null) {
                tail = null;
                currentNode = null;
            }
            return true;
        }

        // case 2: removing elsewhere
        Node prev = head;
        Node curr = head.next;

        while (curr != null) {
            if (curr.song.getTitle().equalsIgnoreCase(title)) {
                if (currentNode == curr) currentNode = curr.next;

                prev.next = curr.next;

                // if removed tail, update tail
                if (curr == tail) tail = prev;

                size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }

        return false; // not found
    }

    public Song playNext() {
        if (head == null) return null;

        // if currentNode is null, start at head
        if (currentNode == null) currentNode = head;
        else currentNode = (currentNode.next != null) ? currentNode.next : head;

        return currentNode.song;
    }

    public void displayPlaylist() {
        if (head == null) {
            System.out.println("(playlist is empty)");
            return;
        }

        Node temp = head;
        int i = 1;
        while (temp != null) {
            System.out.println(i + ". " + temp.song);
            temp = temp.next;
            i++;
        }
    }

    public int size() {
        return size;
    }
}
