package com.example.unique_type_name.fragment;

import com.apollographql.android.api.graphql.Field;
import com.apollographql.android.api.graphql.ResponseFieldMapper;
import com.apollographql.android.api.graphql.ResponseReader;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public class HeroDetails {
  public static final String FRAGMENT_DEFINITION = "fragment HeroDetails on Character {\n"
      + "  __typename\n"
      + "  name\n"
      + "  friendsConnection {\n"
      + "    __typename\n"
      + "    totalCount\n"
      + "    edges {\n"
      + "      __typename\n"
      + "      node {\n"
      + "        __typename\n"
      + "        name\n"
      + "      }\n"
      + "    }\n"
      + "  }\n"
      + "}";

  public static final String TYPE_CONDITION = "Character";

  private final @Nonnull String name;

  private final @Nonnull FriendsConnection friendsConnection;

  public HeroDetails(@Nonnull String name, @Nonnull FriendsConnection friendsConnection) {
    this.name = name;
    this.friendsConnection = friendsConnection;
  }

  public @Nonnull String name() {
    return this.name;
  }

  public @Nonnull FriendsConnection friendsConnection() {
    return this.friendsConnection;
  }

  @Override
  public String toString() {
    return "HeroDetails{"
      + "name=" + name + ", "
      + "friendsConnection=" + friendsConnection
      + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HeroDetails) {
      HeroDetails that = (HeroDetails) o;
      return ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
       && ((this.friendsConnection == null) ? (that.friendsConnection == null) : this.friendsConnection.equals(that.friendsConnection));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (name == null) ? 0 : name.hashCode();
    h *= 1000003;
    h ^= (friendsConnection == null) ? 0 : friendsConnection.hashCode();
    return h;
  }

  public static class FriendsConnection {
    private final @Nullable Integer totalCount;

    private final @Nullable List<Edge> edges;

    public FriendsConnection(@Nullable Integer totalCount, @Nullable List<Edge> edges) {
      this.totalCount = totalCount;
      this.edges = edges;
    }

    public @Nullable Integer totalCount() {
      return this.totalCount;
    }

    public @Nullable List<Edge> edges() {
      return this.edges;
    }

    @Override
    public String toString() {
      return "FriendsConnection{"
        + "totalCount=" + totalCount + ", "
        + "edges=" + edges
        + "}";
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof FriendsConnection) {
        FriendsConnection that = (FriendsConnection) o;
        return ((this.totalCount == null) ? (that.totalCount == null) : this.totalCount.equals(that.totalCount))
         && ((this.edges == null) ? (that.edges == null) : this.edges.equals(that.edges));
      }
      return false;
    }

    @Override
    public int hashCode() {
      int h = 1;
      h *= 1000003;
      h ^= (totalCount == null) ? 0 : totalCount.hashCode();
      h *= 1000003;
      h ^= (edges == null) ? 0 : edges.hashCode();
      return h;
    }

    public static class Edge {
      private final @Nullable Node node;

      public Edge(@Nullable Node node) {
        this.node = node;
      }

      public @Nullable Node node() {
        return this.node;
      }

      @Override
      public String toString() {
        return "Edge{"
          + "node=" + node
          + "}";
      }

      @Override
      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (o instanceof Edge) {
          Edge that = (Edge) o;
          return ((this.node == null) ? (that.node == null) : this.node.equals(that.node));
        }
        return false;
      }

      @Override
      public int hashCode() {
        int h = 1;
        h *= 1000003;
        h ^= (node == null) ? 0 : node.hashCode();
        return h;
      }

      public static class Node {
        private final @Nonnull String name;

        public Node(@Nonnull String name) {
          this.name = name;
        }

        public @Nonnull String name() {
          return this.name;
        }

        @Override
        public String toString() {
          return "Node{"
            + "name=" + name
            + "}";
        }

        @Override
        public boolean equals(Object o) {
          if (o == this) {
            return true;
          }
          if (o instanceof Node) {
            Node that = (Node) o;
            return ((this.name == null) ? (that.name == null) : this.name.equals(that.name));
          }
          return false;
        }

        @Override
        public int hashCode() {
          int h = 1;
          h *= 1000003;
          h ^= (name == null) ? 0 : name.hashCode();
          return h;
        }

        public static final class Mapper implements ResponseFieldMapper<Node> {
          final Field[] fields = {
            Field.forString("name", "name", null, false)
          };

          @Override
          public Node map(ResponseReader reader) throws IOException {
            final __ContentValues contentValues = new __ContentValues();
            reader.read(new ResponseReader.ValueHandler() {
              @Override
              public void handle(final int fieldIndex, final Object value) throws IOException {
                switch (fieldIndex) {
                  case 0: {
                    contentValues.name = (String) value;
                    break;
                  }
                }
              }
            }, fields);
            return new Node(contentValues.name);
          }

          static final class __ContentValues {
            String name;
          }
        }
      }

      public static final class Mapper implements ResponseFieldMapper<Edge> {
        final Field[] fields = {
          Field.forObject("node", "node", null, true, new Field.ObjectReader<Node>() {
            @Override public Node read(final ResponseReader reader) throws IOException {
              return new Node.Mapper().map(reader);
            }
          })
        };

        @Override
        public Edge map(ResponseReader reader) throws IOException {
          final __ContentValues contentValues = new __ContentValues();
          reader.read(new ResponseReader.ValueHandler() {
            @Override
            public void handle(final int fieldIndex, final Object value) throws IOException {
              switch (fieldIndex) {
                case 0: {
                  contentValues.node = (Node) value;
                  break;
                }
              }
            }
          }, fields);
          return new Edge(contentValues.node);
        }

        static final class __ContentValues {
          Node node;
        }
      }
    }

    public static final class Mapper implements ResponseFieldMapper<FriendsConnection> {
      final Field[] fields = {
        Field.forInt("totalCount", "totalCount", null, true),
        Field.forList("edges", "edges", null, true, new Field.ObjectReader<Edge>() {
          @Override public Edge read(final ResponseReader reader) throws IOException {
            return new Edge.Mapper().map(reader);
          }
        })
      };

      @Override
      public FriendsConnection map(ResponseReader reader) throws IOException {
        final __ContentValues contentValues = new __ContentValues();
        reader.read(new ResponseReader.ValueHandler() {
          @Override
          public void handle(final int fieldIndex, final Object value) throws IOException {
            switch (fieldIndex) {
              case 0: {
                contentValues.totalCount = (Integer) value;
                break;
              }
              case 1: {
                contentValues.edges = (List<Edge>) value;
                break;
              }
            }
          }
        }, fields);
        return new FriendsConnection(contentValues.totalCount, contentValues.edges);
      }

      static final class __ContentValues {
        Integer totalCount;

        List<Edge> edges;
      }
    }
  }

  public static final class Mapper implements ResponseFieldMapper<HeroDetails> {
    final Field[] fields = {
      Field.forString("name", "name", null, false),
      Field.forObject("friendsConnection", "friendsConnection", null, false, new Field.ObjectReader<FriendsConnection>() {
        @Override public FriendsConnection read(final ResponseReader reader) throws IOException {
          return new FriendsConnection.Mapper().map(reader);
        }
      })
    };

    @Override
    public HeroDetails map(ResponseReader reader) throws IOException {
      final __ContentValues contentValues = new __ContentValues();
      reader.read(new ResponseReader.ValueHandler() {
        @Override
        public void handle(final int fieldIndex, final Object value) throws IOException {
          switch (fieldIndex) {
            case 0: {
              contentValues.name = (String) value;
              break;
            }
            case 1: {
              contentValues.friendsConnection = (FriendsConnection) value;
              break;
            }
          }
        }
      }, fields);
      return new HeroDetails(contentValues.name, contentValues.friendsConnection);
    }

    static final class __ContentValues {
      String name;

      FriendsConnection friendsConnection;
    }
  }
}
