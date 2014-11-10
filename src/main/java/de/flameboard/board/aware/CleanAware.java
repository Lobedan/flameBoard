package de.flameboard.board.aware;

/**
 * Created by Sven on 08.11.2014.
 *
 * this function indicates its implementing classes, that they have to
 * clean there classfields
 * this function is meant for builder classes annotated with {@link de.flameboard.board.annotation.Builder}
 */
public interface CleanAware {
  void clear();
}
