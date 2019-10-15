package uk.co.devgrid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import uk.co.devgrid.model.Contestant;

public class App {
/*
	public static void down(String[] args) {

		Scanner scan = new Scanner(System.in);
		final List<List<Contestant>> result = new ArrayList<>();

		int cases = Integer.parseInt(scan.nextLine());
		String input;

		for (int i = 0; i < cases; i++) {
			final Map<Integer, Contestant> map = new HashMap<>();
			while ((input = scan.nextLine()).length() > 0) {
				processCases(map, input);
			}
			List<Contestant> mapConverted = convertMap(map);
			result.add(mapConverted);
		}
		printResult(result);
	}

	public static Contestant processCases(Map<Integer, Contestant> map, String input) {
		String[] submission = input.split(" ");
		int contestant = Integer.parseInt(submission[0]);
		int problem = Integer.parseInt(submission[1]);
		int time = Integer.parseInt(submission[2]);
		String letter = submission[3];

		if (map.containsKey(contestant)) {
			return checkLetter(map.get(contestant), problem, time, letter);
		} else {
			Contestant contest = new Contestant(contestant);
			return map.put(contestant, checkLetter(contest, problem, time, letter));
		}
	}

	public static Contestant checkLetter(Contestant contest, int problem, int time, String letter) {
		if (letter.equals("C")) {
			contest.addProblemSolved(problem);
			contest.increaseTimeExpended(time);
		} else if (letter.equals("I")) {
			contest.increaseTimeExpended(20);
		}
		return contest;
	}

	public static List<Contestant> convertMap(Map<Integer, Contestant> map) {
		List<Contestant> result = new ArrayList<>(map.values());
		map.clear();
		
		Collections.sort(result);
		return result;
	}

	public static void printResult(List<List<Contestant>> result) {
		result.forEach((temp) -> {
			temp.forEach(System.out::println);
			System.out.println();
		});
	}*/
}
