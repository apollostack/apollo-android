package com.example.fragment_in_fragment.fragment;

import com.apollographql.apollo.api.Field;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.internal.Optional;
import java.io.IOException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("Apollo GraphQL")
public class PilotFragment {
  public static final String FRAGMENT_DEFINITION = "fragment pilotFragment on Person {\n"
      + "  __typename\n"
      + "  name\n"
      + "  homeworld {\n"
      + "    __typename\n"
      + "    name\n"
      + "  }\n"
      + "}";

  public static final List<String> POSSIBLE_TYPES = Collections.unmodifiableList(Arrays.asList( "Person"));

  private final Optional<String> name;

  private final Optional<Homeworld> homeworld;

  private volatile String $toString;

  private volatile int $hashCode;

  private volatile boolean $hashCodeMemoized;

  public PilotFragment(@Nullable String name, @Nullable Homeworld homeworld) {
    this.name = Optional.fromNullable(name);
    this.homeworld = Optional.fromNullable(homeworld);
  }

  /**
   * The name of this person.
   */
  public Optional<String> name() {
    return this.name;
  }

  /**
   * A planet that this person was born on or inhabits.
   */
  public Optional<Homeworld> homeworld() {
    return this.homeworld;
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "PilotFragment{"
        + "name=" + name + ", "
        + "homeworld=" + homeworld
        + "}";
    }
    return $toString;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PilotFragment) {
      PilotFragment that = (PilotFragment) o;
      return ((this.name == null) ? (that.name == null) : this.name.equals(that.name))
       && ((this.homeworld == null) ? (that.homeworld == null) : this.homeworld.equals(that.homeworld));
    }
    return false;
  }

  @Override
  public int hashCode() {
    if (!$hashCodeMemoized) {
      int h = 1;
      h *= 1000003;
      h ^= (name == null) ? 0 : name.hashCode();
      h *= 1000003;
      h ^= (homeworld == null) ? 0 : homeworld.hashCode();
      $hashCode = h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  public static final class Mapper implements ResponseFieldMapper<PilotFragment> {
    final Homeworld.Mapper homeworldFieldMapper = new Homeworld.Mapper();

    final Field[] fields = {
      Field.forString("name", "name", null, true),
      Field.forObject("homeworld", "homeworld", null, true, new Field.ObjectReader<Homeworld>() {
        @Override public Homeworld read(final ResponseReader reader) throws IOException {
          return homeworldFieldMapper.map(reader);
        }
      })
    };

    @Override
    public PilotFragment map(ResponseReader reader) throws IOException {
      final String name = reader.read(fields[0]);
      final Homeworld homeworld = reader.read(fields[1]);
      return new PilotFragment(name, homeworld);
    }
  }

  public static class Homeworld {
    private final Optional<String> name;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Homeworld(@Nullable String name) {
      this.name = Optional.fromNullable(name);
    }

    /**
     * The name of this planet.
     */
    public Optional<String> name() {
      return this.name;
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Homeworld{"
          + "name=" + name
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Homeworld) {
        Homeworld that = (Homeworld) o;
        return ((this.name == null) ? (that.name == null) : this.name.equals(that.name));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (name == null) ? 0 : name.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Homeworld> {
      final Field[] fields = {
        Field.forString("name", "name", null, true)
      };

      @Override
      public Homeworld map(ResponseReader reader) throws IOException {
        final String name = reader.read(fields[0]);
        return new Homeworld(name);
      }
    }
  }
}
